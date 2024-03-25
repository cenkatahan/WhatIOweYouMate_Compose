package com.ata.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.usecase.GetFriendsUseCase
import com.ata.core.domain.usecase.RemoveFriendsUseCase
import com.ata.core.domain.usecase.RemoveUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val removeUseCase: RemoveUseCase,
    private val getFriendsUseCase: GetFriendsUseCase,
    private val removeFriendsUseCase: RemoveFriendsUseCase
) : ViewModel() {

    init {
        fetchFriends()
    }

    private val _friendsState: MutableStateFlow<HomeUIState<List<Friend>>> =
        MutableStateFlow(HomeUIState.Loading)
    val friendsState = _friendsState.asStateFlow()

    private val _removeFriendState: MutableStateFlow<RemoveState<Friend>> =
        MutableStateFlow(RemoveState.Loading)
    val removeFriendState = _removeFriendState.asStateFlow()

    fun remove(friend: Friend) {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                removeUseCase.invoke(friend).collect {
                    _removeFriendState.value = RemoveState.Success()
                    fetchFriends()
                }
            } catch (e: Exception) {
                _removeFriendState.value = RemoveState.Error(e.message!!)
            }
        }
    }

    private fun fetchFriends() = viewModelScope.launch(Dispatchers.Default) {
        try {

            getFriendsUseCase.invoke().collect {
                _friendsState.value = HomeUIState.Success(it)
            }
        } catch (e: Exception) {
            _friendsState.value = HomeUIState.Error(e.message!!)
        }
    }

    fun removeAll() {
        viewModelScope.launch(Dispatchers.Default) {
            //add state
            removeFriendsUseCase.invoke()
        }
    }
}

sealed class RemoveState<out T: Any?> {
    data class Success<out T: Any>(val data: T? = null) : RemoveState<T>()
    data class Error(val message: String) : RemoveState<Nothing>()
    object Loading : RemoveState<Nothing>()
}
package com.ata.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.usecase.GetFriendsUseCase
import com.ata.core.domain.usecase.RemoveFriendsUseCase
import com.ata.core.domain.usecase.RemoveUseCase
import com.ata.core.util.Resource
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

    private val _removeFriendState: MutableStateFlow<RemoveUIState> =
        MutableStateFlow(RemoveUIState.Loading)
    val removeFriendState = _removeFriendState.asStateFlow()

    fun remove(friend: Friend) {
        viewModelScope.launch(Dispatchers.Default) {

            removeUseCase.invoke(friend).collect { resource ->
                when (resource) {
                    is Resource.Error -> _removeFriendState.value =
                        RemoveUIState.Error(resource.message!!)

                    is Resource.Loading -> _removeFriendState.value = RemoveUIState.Loading
                    is Resource.Success -> _removeFriendState.value =
                        RemoveUIState.Success(resource.data!!)
                }

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

sealed class RemoveUIState {
    data class Success(val data: Friend) : RemoveUIState()
    data class Error(val message: String) : RemoveUIState()
    object Loading : RemoveUIState()
}
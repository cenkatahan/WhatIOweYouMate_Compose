package com.ata.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.usecase.GetFriendsUseCase
import com.ata.core.domain.usecase.RemoveFriendsUseCase
import com.ata.core.domain.usecase.RemoveUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val removeUseCase: RemoveUseCase,
    private val getFriendsUseCase: GetFriendsUseCase,
    private val removeFriendsUseCase: RemoveFriendsUseCase
) : ViewModel() {

    fun remove(friend: Friend) {
        viewModelScope.launch(Dispatchers.Default) {
            removeUseCase.invoke(friend)
        }
    }

    fun fetchFriends() = viewModelScope.launch(Dispatchers.Default) {
        getFriendsUseCase.invoke().collect{
            //add state
        }
    }

    fun removeAll() {
        viewModelScope.launch(Dispatchers.Default) {
            //add state
            removeFriendsUseCase.invoke()
        }
    }
}
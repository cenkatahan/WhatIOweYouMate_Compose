package com.ata.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.usecase.GetFriendsUseCase
import com.ata.core.domain.usecase.RemoveUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    //usecase
): ViewModel() {
    private val removeUseCase: RemoveUseCase,

    fun remove(friend: Friend) {
        viewModelScope.launch {
            removeUseCase.invoke(friend)
        }
    }

}
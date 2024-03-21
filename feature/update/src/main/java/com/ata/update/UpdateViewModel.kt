package com.ata.update

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.usecase.UpdateFriendUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(
    private val updateFriendUseCase: UpdateFriendUseCase
) : ViewModel() {
    fun update(friend: Friend) {
        viewModelScope.launch {
            try {
                updateFriendUseCase.invoke(friend)
                //state = Success
            } catch (e: Exception) {
                //sate = Error
            }

        }
    }
}
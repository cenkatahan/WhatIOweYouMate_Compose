package com.ata.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.usecase.SaveFriendUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val saveFriendUseCase: SaveFriendUseCase
): ViewModel() {
    //todo add state.?
    suspend fun save(friend: Friend){
        viewModelScope.launch {
            try {
                saveFriendUseCase.invoke(friend)
                //state = Success
            } catch (e: Exception) {
                //sate = Error
            }

        }
    }
}
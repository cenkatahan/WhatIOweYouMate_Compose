package com.ata.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.usecase.SaveFriendUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val saveFriendUseCase: SaveFriendUseCase,
) : ViewModel() {
    private var _addFriendState: MutableStateFlow<AddUIState<Friend>> =
        MutableStateFlow(AddUIState.Loading)
    val addFriendState = _addFriendState.asStateFlow()
    fun save(friend: Friend) {
        viewModelScope.launch {
            try {
                saveFriendUseCase.invoke(friend).collect{
                    _addFriendState.value = AddUIState.Success()
                }
            } catch (e: Exception) {
                _addFriendState.value = AddUIState.Error(e.message!!)
            }

        }
    }
}


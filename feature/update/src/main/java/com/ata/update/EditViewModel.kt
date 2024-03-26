package com.ata.update

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.usecase.GetFriendUseCase
import com.ata.core.domain.usecase.UpdateFriendUseCase
import com.ata.core.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val updateFriendUseCase: UpdateFriendUseCase,
    private val getFriendUseCase: GetFriendUseCase
) : ViewModel() {


    private val _editState: MutableStateFlow<EditUIState> =
        MutableStateFlow(EditUIState.Loading)
    val editState = _editState.asStateFlow()

    private val _friendState: MutableStateFlow<EditUIState> =
        MutableStateFlow(EditUIState.Loading)
    val friendState = _friendState.asStateFlow()

    fun update(friend: Friend) {
        viewModelScope.launch {
            updateFriendUseCase.invoke(friend).collect { resource ->
                when (resource) {
                    is Resource.Error -> _editState.value = EditUIState.Error(resource.message!!)
                    is Resource.Loading -> _editState.value = EditUIState.Loading
                    is Resource.Success -> _editState.value = EditUIState.Success(resource.data!!)
                }
            }
        }
    }

    fun getFriend(id: Int) {
        viewModelScope.launch {
            try {
                getFriendUseCase.invoke(id).collect {
                    _friendState.value = EditUIState.Success(it)
                }

            } catch (e: Exception) {
                _friendState.value = EditUIState.Error(e.message!!)
            }

        }
    }
}

sealed class EditUIState {
    object Loading : EditUIState()
    data class Success(val data: Friend) : EditUIState()
    data class Error(val msg: String) : EditUIState()
}
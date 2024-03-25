package com.ata.add

sealed class AddUIState<out T: Any?> {
    data class Success<out T: Any>(val data: T? = null) : AddUIState<T>()
    data class Error(val message: String) : AddUIState<Nothing>()
    object Loading : AddUIState<Nothing>()
}
package com.ata.home

sealed class HomeUIState<out T: Any?> {
    data class Success<out T: Any>(val data: T) : HomeUIState<T>()
    data class Error(val message: String) : HomeUIState<Nothing>()
    object Loading : HomeUIState<Nothing>()
}
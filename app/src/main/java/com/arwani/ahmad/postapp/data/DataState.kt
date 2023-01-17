package com.arwani.ahmad.postapp.data

sealed class DataState<out R> private constructor() {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val error: String) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}
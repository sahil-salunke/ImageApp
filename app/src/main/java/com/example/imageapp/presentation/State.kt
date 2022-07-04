package com.example.imageapp.presentation

/**
 * Sealed class to manage network states
 * @author Sahil Salunke
 * @since 4/7/2022
 */
sealed class State<out T> {
    object LoadingState : State<Nothing>()
    data class ErrorState(var exception: Throwable) : State<Nothing>()
    data class DataState<T>(var data: T) : State<T>()
}
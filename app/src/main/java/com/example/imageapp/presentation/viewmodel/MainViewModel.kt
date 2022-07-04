package com.example.imageapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imageapp.domain.ImageUseCase
import com.example.imageapp.presentation.State
import com.example.imageapp.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel class to work as a bridge between UI and business logic
 * @author Sahil Salunke
 * @since 4/7/2022
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val imageUseCase: ImageUseCase) :
    ViewModel() {

    private fun getImageResponse() = flow {
        emit(State.LoadingState)
        try {
            delay(1000)
            emit(State.DataState(imageUseCase()))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Utils.resolveError(e))
        }
    }

    /**
     * Method to call api of image and manage response
     */
    fun getImageData() {
        viewModelScope.launch {
            delay(500)
            getImageResponse()
                .collect {
                    when (it) {
                        is State.DataState -> {
                            Log.d("Success", "${it.data.content}")
                        }
                        is State.ErrorState -> Log.d("Error", "${it.exception}")
                        is State.LoadingState -> "loading"
                    }
                }
        }
    }


}
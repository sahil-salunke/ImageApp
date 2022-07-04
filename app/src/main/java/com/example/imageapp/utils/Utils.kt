package com.example.imageapp.utils

import android.accounts.NetworkErrorException
import com.example.imageapp.presentation.AuthenticationException
import com.example.imageapp.presentation.State
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Util class for common use logics
 * @author Sahil Salunke
 * @since 4/7/2022
 */
class Utils {
    companion object {

        // function to manage errors
        fun resolveError(e: Exception): State.ErrorState {
            var error = e

            when (e) {
                is SocketTimeoutException -> {
                    error = NetworkErrorException("connection error!")
                }
                is ConnectException -> {
                    error = NetworkErrorException("no internet access!")
                }
                is UnknownHostException -> {
                    error = NetworkErrorException("no internet access!")
                }
            }
            if (e is HttpException) {
                when (e.code()) {
                    502 -> {
                        error = NetworkErrorException(e.code().toString())
                    }
                    401 -> {
                        throw AuthenticationException("authentication error!")
                    }
                    400 -> {
                        error = NetworkErrorException(e.code().toString())
                    }
                }
            }
            return State.ErrorState(error)
        }
    }
}
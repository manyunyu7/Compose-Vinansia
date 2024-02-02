package com.feylabs.core.helper.error

import android.accounts.NetworkErrorException
import com.feylabs.core.helper.wrapper.ResponseState
import kotlinx.coroutines.flow.FlowCollector
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ResponseExceptionHandler {
    suspend fun <T> handleException(
        exception: Exception,
        flow: FlowCollector<ResponseState<T>>
    ) {
        when (exception) {
            is HttpException -> {
                val errorMessage = "HTTP error: ${exception.code()} - ${exception.message()}"
                flow.emit(ResponseState.Error(ErrorResponse(errorMessage)))
            }
            is SocketTimeoutException -> {
                val message = mapErrorMessage(exception.message, "Socket timeout error")
                flow.emit(ResponseState.Error(ErrorResponse(message)))
            }
            is ConnectException -> {
                val message = mapErrorMessage(exception.message, "Connection error")
                flow.emit(ResponseState.Error(ErrorResponse(message)))
            }
            is UnknownHostException -> {
                val message = mapErrorMessage(exception.message, "Unknown host error")
                flow.emit(ResponseState.Error(ErrorResponse(message)))
            }
            is IOException -> {
                val message = mapErrorMessage(exception.message, "Network error")
                flow.emit(ResponseState.Error(ErrorResponse(message)))
            }
            is NetworkErrorException -> {
                val message = mapErrorMessage(exception.message, "Network connection error")
                flow.emit(ResponseState.Error(ErrorResponse(message)))
            }
            else -> {
                val message = mapErrorMessage(exception.localizedMessage.toString(), "")
                flow.emit(ResponseState.Error(ErrorResponse(message)))
            }
        }
    }

    private fun mapErrorMessage(originalMessage: String?, defaultMessage: String): String {
        val message = originalMessage?.toLowerCase()
        return when {
            message == null -> defaultMessage
            message.contains("timeout") -> "The request timed out. Please try again later."
            message.contains("reset") -> "The connection was reset. Please try again later."
            message.contains("dns lookup failed") -> "The DNS lookup failed. Please check your internet connection."
            else -> defaultMessage
        }
    }
}
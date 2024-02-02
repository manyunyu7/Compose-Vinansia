package com.feylabs.core.helper.wrapper

import com.feylabs.core.helper.error.ErrorResponse

sealed class ResponseState<T>(
    val data: T? = null,
    val message: String? = null,
    val errorResponse: ErrorResponse? = null
) {
    class Success<T>(
        data: T? = null,
        val isFromCache: Boolean = false,
        val toBeCleared: Boolean = false
    ) :
        ResponseState<T>(data = data)

    class Error<T>(errorResponse: ErrorResponse? = null) :
        ResponseState<T>(errorResponse = errorResponse)

    class Loading<T>(data: T? = null) : ResponseState<T>(data = data)
}
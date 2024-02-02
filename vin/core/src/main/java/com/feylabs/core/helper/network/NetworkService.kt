package com.feylabs.core.helper.network

import okhttp3.OkHttpClient
import okhttp3.Request

class NetworkHelper {

    private val okHttpClient = OkHttpClient()

    fun isOnline(): Boolean {
        val request = Request.Builder().url("https://www.google.com").build()
        return try {
            val response = okHttpClient.newCall(request).execute()
            response.isSuccessful
        } catch (e: Exception) {
            false
        }
    }

    // other network-related methods here
}
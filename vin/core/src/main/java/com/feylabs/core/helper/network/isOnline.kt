package com.feylabs.core.helper.network

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build

object NetworkInfo {
    /**
     * Checks if the device is currently online and connected to a network.
     *
     * @param connectivityManager the ConnectivityManager instance to use for checking network connectivity.
     * @return true if the device is online, false otherwise.
     */
    fun isOnline(connectivityManager: ConnectivityManager): Boolean {
        var result = false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // If the device is running on API level 23 or higher, use the getNetworkCapabilities() method
            connectivityManager.run {
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.run {
                    result = when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> true
                        else -> false
                    }
                }
            }
        } else {
            // If the device is running on a lower API level, use the deprecated getActiveNetworkInfo() method
            connectivityManager.run {
                val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
                return activeNetwork?.isConnected == true
            }
        }
        return result
    }
}

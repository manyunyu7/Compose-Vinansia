package com.feylabs.vinansia

import dagger.hilt.android.HiltAndroidApp
import android.app.Application

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

}
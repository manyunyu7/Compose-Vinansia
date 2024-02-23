package com.feylabs.unboxing.di

import android.content.Context
import android.net.ConnectivityManager
import com.feylabs.unboxing.data.source.remote.service.UnboxingAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UnboxingModule {


    @Provides
    @Singleton
    @ConnectivityManagerSnips
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
    @Singleton
    @UnboxingSnips
    fun provideAPI(): UnboxingAPI {
        return Retrofit.Builder()
            .baseUrl("https://168.feylabs.my.id/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UnboxingAPI::class.java)
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class UnboxingSnips

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ConnectivityManagerSnips


}
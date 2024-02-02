package com.feylabs.snips.di

import android.content.Context
import android.net.ConnectivityManager
import com.feylabs.snips.data.source.remote.service.SnipsAPI
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
object SnipsModule {


    @Provides
    @Singleton
    @ConnectivityManagerSnips
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
    @Singleton
    @RetrofitSnips
    fun provideLuminaAPI(): SnipsAPI {
        return Retrofit.Builder()
            .baseUrl("https://168.feylabs.my.id/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SnipsAPI::class.java)
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class RetrofitSnips

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ConnectivityManagerSnips


}
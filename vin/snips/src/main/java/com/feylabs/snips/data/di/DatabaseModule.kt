package com.feylabs.snips.data.di

import android.content.Context
import androidx.room.Room
import com.feylabs.snips.data.source.local.dao.SnipsDAO
import com.feylabs.snips.data.source.local.room.SnipsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideSnipsDatabase(@ApplicationContext context: Context): SnipsDatabase {
        return Room.databaseBuilder(context, SnipsDatabase::class.java, "snips-db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideSnipsDao(database: SnipsDatabase): SnipsDAO {
        return database.snipsDao()
    }
}
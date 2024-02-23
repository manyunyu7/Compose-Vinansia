package com.feylabs.unboxing.data.di

import android.content.Context
import androidx.room.Room
import com.feylabs.unboxing.data.source.local.dao.SnipsDAO
import com.feylabs.unboxing.data.source.local.dao.UnboxingDAO
import com.feylabs.unboxing.data.source.local.room.UnboxingDatabase
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
    fun provideSnipsDatabase(@ApplicationContext context: Context): UnboxingDatabase {
        return Room.databaseBuilder(context, UnboxingDatabase::class.java, "unboxing-db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideSnipsDao(database: UnboxingDatabase): SnipsDAO {
        return database.snipsDao()
    }

    @Provides
    fun provideUnboxingDao(database: UnboxingDatabase): UnboxingDAO {
        return database.unboxingDao()
    }
}
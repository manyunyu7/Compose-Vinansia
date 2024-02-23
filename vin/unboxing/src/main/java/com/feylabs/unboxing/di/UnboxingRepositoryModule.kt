package com.feylabs.unboxing.di

import com.feylabs.unboxing.data.repository.UnboxingRepositoryImpl
import com.feylabs.unboxing.domain.repository.UnboxingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UnboxingRepositoryModule {

    @Binds
    abstract fun bindRepository(repository: UnboxingRepositoryImpl): UnboxingRepository
}
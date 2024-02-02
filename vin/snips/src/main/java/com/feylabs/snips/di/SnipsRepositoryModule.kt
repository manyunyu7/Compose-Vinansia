package com.feylabs.snips.di

import com.feylabs.snips.data.repository.SnipsRepositoryImpl
import com.feylabs.snips.domain.repository.SnipsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SnipsRepositoryModule {

    @Binds
    abstract fun bindRepository(luminaRepository: SnipsRepositoryImpl): SnipsRepository
}
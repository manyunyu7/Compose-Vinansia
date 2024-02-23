package com.feylabs.unboxing.di

import com.feylabs.unboxing.domain.interactor.UnboxingInteractor
import com.feylabs.unboxing.domain.usecase.UnboxingUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UnboxingUseCaseModule {
    @Binds
    abstract fun snipUseCaseProvider(useCase: UnboxingInteractor): UnboxingUseCase
}
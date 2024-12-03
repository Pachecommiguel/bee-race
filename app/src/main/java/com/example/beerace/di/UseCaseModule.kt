package com.example.beerace.di

import com.example.beerace.domain.usecase.GetDurationUseCase
import com.example.beerace.domain.usecase.GetDurationUseCaseImp
import com.example.beerace.domain.usecase.GetRaceStatusUseCase
import com.example.beerace.domain.usecase.GetRaceStatusUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Singleton
    @Binds
    abstract fun bindGetDurationUseCase(useCase: GetDurationUseCaseImp): GetDurationUseCase

    @Singleton
    @Binds
    abstract fun bindGetRaceStatusUseCase(useCase: GetRaceStatusUseCaseImp): GetRaceStatusUseCase
}
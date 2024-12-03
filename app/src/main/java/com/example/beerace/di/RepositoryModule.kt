package com.example.beerace.di

import com.example.beerace.data.repository.RaceRepositoryImp
import com.example.beerace.domain.RaceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRaceRepository(repository: RaceRepositoryImp): RaceRepository
}
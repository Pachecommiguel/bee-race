package com.example.beerace.domain.usecase

import com.example.beerace.domain.RaceRepository
import javax.inject.Inject

class GetDurationUseCaseImp @Inject constructor(
    private val raceRepository: RaceRepository
) : GetDurationUseCase {

    override suspend fun invoke() = raceRepository.getDuration()
}
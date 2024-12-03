package com.example.beerace.domain.usecase

import com.example.beerace.domain.RaceRepository
import javax.inject.Inject

class GetRaceStatusUseCaseImp @Inject constructor(
    private val raceRepository: RaceRepository
) : GetRaceStatusUseCase {

    override suspend fun invoke() = raceRepository.getRaceStatus()
}
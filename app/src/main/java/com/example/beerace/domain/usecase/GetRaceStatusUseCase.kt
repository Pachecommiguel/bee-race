package com.example.beerace.domain.usecase

import com.example.beerace.domain.model.RaceStatus

interface GetRaceStatusUseCase {
    suspend operator fun invoke(): RaceStatus
}
package com.example.beerace.domain.usecase

import com.example.beerace.domain.model.Duration

interface GetDurationUseCase {
    suspend operator fun invoke(): Duration
}
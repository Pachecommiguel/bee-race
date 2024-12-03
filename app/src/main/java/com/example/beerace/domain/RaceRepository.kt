package com.example.beerace.domain

import com.example.beerace.domain.model.Duration
import com.example.beerace.domain.model.RaceStatus

interface RaceRepository {
    suspend fun getDuration(): Duration
    suspend fun getRaceStatus(): RaceStatus
}
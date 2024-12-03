package com.example.beerace.data.repository

import com.example.beerace.data.service.RaceService
import com.example.beerace.domain.RaceRepository
import com.example.beerace.domain.model.Bee
import com.example.beerace.domain.model.Duration
import com.example.beerace.domain.model.RaceStatus
import com.example.beerace.ui.toMillis
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RaceRepositoryImp @Inject constructor(
    private val service: RaceService
) : RaceRepository {

    override suspend fun getDuration(): Duration {
        val dto = service.getDuration()
        if (dto.timeInSeconds == null || dto.timeInSeconds == 0) {
            return Duration.INVALID
        }

        return Duration.VALID(millis = dto.timeInSeconds.toMillis())
    }

    override suspend fun getRaceStatus(): RaceStatus {
        val dto = service.getRaceStatus()
        if (dto.beeList.isNullOrEmpty()) {
            return RaceStatus.INVALID
        }

        return RaceStatus.VALID(bees = dto.beeList.map {
            Bee(name = it.name ?: "Unknown")
        })
    }
}
package com.example.beerace.data.service

import com.example.beerace.data.Endpoint
import com.example.beerace.data.dto.DurationDTO
import com.example.beerace.data.dto.RaceStatusDTO
import retrofit2.http.GET

interface RaceService {

    @GET(Endpoint.DURATION)
    suspend fun getDuration(): DurationDTO

    @GET(Endpoint.STATUS)
    suspend fun getRaceStatus(): RaceStatusDTO
}
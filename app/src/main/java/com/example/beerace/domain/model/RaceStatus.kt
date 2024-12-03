package com.example.beerace.domain.model

sealed class RaceStatus {
    data object INVALID : RaceStatus()
    data class VALID(val bees: List<Bee>) : RaceStatus()
}
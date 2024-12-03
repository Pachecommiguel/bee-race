package com.example.beerace.domain.model

sealed class Duration {
    data object INVALID : Duration()
    data class VALID(val millis: Long) : Duration()
}
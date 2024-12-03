package com.example.beerace.ui.event

sealed class HomeEvent {
    data object UpdateRaceStatus : HomeEvent()
    data object StartOver : HomeEvent()
}
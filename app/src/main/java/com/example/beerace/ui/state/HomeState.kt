package com.example.beerace.ui.state

import com.example.beerace.domain.model.Bee

sealed class HomeState {
    data object Loading : HomeState()
    data class Success(val millis: Long? = null, val bees: List<Bee> = listOf()) : HomeState()
    data object Error : HomeState()
}
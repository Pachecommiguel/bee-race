package com.example.beerace.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beerace.domain.model.Duration
import com.example.beerace.domain.model.RaceStatus
import com.example.beerace.domain.usecase.GetDurationUseCase
import com.example.beerace.domain.usecase.GetRaceStatusUseCase
import com.example.beerace.ui.event.HomeEvent
import com.example.beerace.ui.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDurationUseCase: GetDurationUseCase,
    private val getRaceStatusUseCase: GetRaceStatusUseCase
) : ViewModel(), BaseViewModel<HomeEvent, HomeState> {

    override val state = MutableStateFlow<HomeState>(value = HomeState.Loading)

    init {
        start()
    }

    override fun onEvent(event: HomeEvent) {
        when(event) {
            HomeEvent.UpdateRaceStatus -> onUpdateRaceStatusEvent()
            HomeEvent.StartOver -> onStartOverEvent()
        }
    }

    private fun start() {
        viewModelScope.launch(context = CoroutineExceptionHandler { _, _ ->

        }) {
            state.value = when(val duration = getDurationUseCase()) {
                Duration.INVALID -> HomeState.Error
                is Duration.VALID -> HomeState.Success(millis = duration.millis)
            }
        }
    }

    private fun onStartOverEvent() {
        start()
    }

    private fun onUpdateRaceStatusEvent() {
        viewModelScope.launch(context = CoroutineExceptionHandler { _, _ ->

        }) {
            val status = getRaceStatusUseCase()
            if (status is RaceStatus.VALID) {
                state.value = HomeState.Success(bees = status.bees)
            }
        }
    }
}
package com.example.beerace.ui.view

import android.os.CountDownTimer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.beerace.ui.event.HomeEvent
import com.example.beerace.ui.state.HomeState
import com.example.beerace.ui.toClockString
import com.example.beerace.ui.viewmodel.BaseViewModel
import com.example.beerace.ui.viewmodel.HomeViewModel

@Composable
fun HomeView() {
    val viewModel: BaseViewModel<HomeEvent, HomeState> = hiltViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsState()

    when(state) {
        HomeState.Loading -> {}
        HomeState.Error -> {}
        is HomeState.Success -> HomeLayout(
            state = state as HomeState.Success,
            onEvent = viewModel::onEvent
        )
    }
}

@Composable
private fun HomeLayout(state: HomeState.Success, onEvent: (HomeEvent) -> Unit) {
    var timeRemaining by remember {
        mutableLongStateOf(value = state.millis ?: 0L)
    }

    state.millis?.let {
        timeRemaining = it
        val countDownTimer = object : CountDownTimer(timeRemaining, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeRemaining = millisUntilFinished
                onEvent(HomeEvent.UpdateRaceStatus)
            }

            override fun onFinish() {}
        }

        countDownTimer.start()
    }

    Column {
        Text("Time remaining")
        Text(text = timeRemaining.toClockString())

        Button(onClick = {
            onEvent(HomeEvent.StartOver)
        }) {
            Text("Again!")
        }

        LazyColumn {
            items(items = state.bees) {
                Text(text = it.name)
            }
        }
    }
}

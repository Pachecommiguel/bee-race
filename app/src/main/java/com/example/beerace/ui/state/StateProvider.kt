package com.example.beerace.ui.state

import kotlinx.coroutines.flow.MutableStateFlow

interface StateProvider<TState> {
    val state: MutableStateFlow<TState>
}
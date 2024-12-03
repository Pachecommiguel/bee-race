package com.example.beerace.ui.viewmodel

import com.example.beerace.ui.event.EventListener
import com.example.beerace.ui.state.StateProvider

interface BaseViewModel<TEvent, TState> : EventListener<TEvent>, StateProvider<TState>
package com.example.beerace.ui.event

interface EventListener<TEvent> {
    fun onEvent(event: TEvent)
}
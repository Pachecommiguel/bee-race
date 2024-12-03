package com.example.beerace.ui

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Int.toMillis() = this * 1000L

fun Long.toClockString() = SimpleDateFormat("mm:ss", Locale.getDefault()).format(Date(this))
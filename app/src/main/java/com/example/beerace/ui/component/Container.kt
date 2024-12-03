package com.example.beerace.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.beerace.ui.theme.BeeRaceTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Container(content: @Composable BoxScope.() -> Unit) {
    BeeRaceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.padding(all = 16.dp), content = content)
        }
    }
}
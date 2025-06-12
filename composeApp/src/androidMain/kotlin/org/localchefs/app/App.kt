package org.localchefs.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.localchefs.app.presentation.screens.ChefListScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        ChefListScreen()
    }
}
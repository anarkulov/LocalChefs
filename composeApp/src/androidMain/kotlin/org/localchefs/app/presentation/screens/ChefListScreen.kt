package org.localchefs.app.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.getKoin
import org.localchefs.app.shared.presentation.viewmodel.ChefProfileViewModel

@Composable
fun ChefListScreen() {
    val viewModel: ChefProfileViewModel = getKoin().get()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadChefs()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            state.error != null -> {
                Text(
                    text = state.error ?: "Unknown error",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(state.chefs) { chef ->
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(text = chef.name ?: "Unnamed Chef", style = MaterialTheme.typography.titleMedium)
                            Text(text = chef.city ?: "Unknown City", style = MaterialTheme.typography.bodyMedium)
                            Text(
                                text = chef.cuisines?.joinToString() ?: "No cuisines listed",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
    }
} 
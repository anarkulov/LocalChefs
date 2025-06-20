package org.localchefs.app.shared.presentation.home

data class HomeState(
    val zipCode: String = "",
    val latitude: Float = 0f,
    val longitude: Float = 0f,
    val isDistanceMenuExpanded: Boolean = false,
    val selectedDistance: Int = 50,
    val isLoading: Boolean = false,
    val error: String? = null,
    val showRationaleDialog: Boolean = false,
    val showSettingsDialog: Boolean = false
)
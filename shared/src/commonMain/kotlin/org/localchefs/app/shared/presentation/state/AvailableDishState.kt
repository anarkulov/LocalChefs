package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.AvailableDish

data class AvailableDishState(
    val availableDishes: List<AvailableDish> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
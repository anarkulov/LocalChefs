package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.ChefProfile

data class ChefProfileState(
    val chefs: List<ChefProfile> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
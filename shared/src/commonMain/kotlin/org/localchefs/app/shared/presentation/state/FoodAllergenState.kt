package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.FoodAllergen

data class FoodAllergenState(
    val foodAllergens: List<FoodAllergen> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
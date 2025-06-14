package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.Dish

data class DishState(
    val dishes: List<Dish> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
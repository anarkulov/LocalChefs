package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.DishCategory

data class DishCategoryState(
    val categories: List<DishCategory> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
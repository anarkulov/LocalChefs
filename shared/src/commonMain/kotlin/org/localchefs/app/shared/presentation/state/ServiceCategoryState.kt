package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.ServiceCategory

data class ServiceCategoryState(
    val categories: List<ServiceCategory> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
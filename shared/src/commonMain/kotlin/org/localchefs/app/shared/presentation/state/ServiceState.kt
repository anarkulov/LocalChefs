package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.Service

data class ServiceState(
    val services: List<Service> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.Order

data class OrderState(
    val orders: List<Order> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
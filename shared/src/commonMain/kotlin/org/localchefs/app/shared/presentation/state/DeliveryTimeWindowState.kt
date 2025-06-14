package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.DeliveryTimeWindow

data class DeliveryTimeWindowState(
    val deliveryTimeWindows: List<DeliveryTimeWindow> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
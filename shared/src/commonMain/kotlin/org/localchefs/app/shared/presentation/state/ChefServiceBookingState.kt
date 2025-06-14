package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.ChefServiceBooking

data class ChefServiceBookingState(
    val bookings: List<ChefServiceBooking> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
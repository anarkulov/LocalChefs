package org.localchefs.app.shared.domain.usecase.serviceBooking

import org.localchefs.app.shared.domain.model.ChefServiceBooking
import org.localchefs.app.shared.domain.repository.ChefServiceBookingRepository

class GetChefServiceBookingsUseCase(private val repository: ChefServiceBookingRepository) {
    suspend operator fun invoke(): List<ChefServiceBooking> = repository.getAll()
} 
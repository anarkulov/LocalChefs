package org.localchefs.app.shared.domain.usecase.availableDish

import org.localchefs.app.shared.domain.model.AvailableDish
import org.localchefs.app.shared.domain.repository.AvailableDishRepository

class GetAvailableDishesUseCase(private val repository: AvailableDishRepository) {
    suspend operator fun invoke(): List<AvailableDish> = repository.getAll()
} 
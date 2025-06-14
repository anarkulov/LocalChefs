package org.localchefs.app.shared.domain.usecase.delivery

import org.localchefs.app.shared.domain.model.DeliveryTimeWindow
import org.localchefs.app.shared.domain.repository.DeliveryTimeWindowRepository

class GetDeliveryTimeWindowsUseCase(private val repository: DeliveryTimeWindowRepository) {
    suspend operator fun invoke(): List<DeliveryTimeWindow> = repository.getAll()
} 
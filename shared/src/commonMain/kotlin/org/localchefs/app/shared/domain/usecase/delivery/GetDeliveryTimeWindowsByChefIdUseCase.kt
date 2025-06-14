package org.localchefs.app.shared.domain.usecase.delivery

import org.localchefs.app.shared.domain.model.DeliveryTimeWindow
import org.localchefs.app.shared.domain.repository.DeliveryTimeWindowRepository

class GetDeliveryTimeWindowsByChefIdUseCase(private val repository: DeliveryTimeWindowRepository) {
    suspend operator fun invoke(chefId: String): List<DeliveryTimeWindow> = repository.getByChefId(chefId)
} 
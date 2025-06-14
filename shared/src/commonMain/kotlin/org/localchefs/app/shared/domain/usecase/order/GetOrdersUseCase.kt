package org.localchefs.app.shared.domain.usecase.order

import org.localchefs.app.shared.domain.model.Order
import org.localchefs.app.shared.domain.repository.OrderRepository

class GetOrdersUseCase(private val repository: OrderRepository) {
    suspend operator fun invoke(): List<Order> = repository.getAll()
} 
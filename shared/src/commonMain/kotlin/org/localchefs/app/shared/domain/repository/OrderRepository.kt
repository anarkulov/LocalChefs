package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.Order

interface OrderRepository {
    suspend fun getAll(): List<Order>
    suspend fun getById(id: String): Order?
    suspend fun insert(order: Order): Order?
    suspend fun update(id: String, order: Order): Order?
    suspend fun delete(id: String)
} 
package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.OrderApi
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.Order
import org.localchefs.app.shared.domain.repository.OrderRepository

class OrderRepositoryImpl(private val api: OrderApi) : OrderRepository {
    override suspend fun getAll(): List<Order> = api.getAll()
    override suspend fun getById(id: String): Order? = api.getById(id)
    override suspend fun insert(order: Order): Order? = api.insert(order)
    override suspend fun update(id: String, order: Order): Order? = api.update(id, order)
    override suspend fun delete(id: String) = api.delete(id)
} 
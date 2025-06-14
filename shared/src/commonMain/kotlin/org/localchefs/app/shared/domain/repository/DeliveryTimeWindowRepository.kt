package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.DeliveryTimeWindow

interface DeliveryTimeWindowRepository {
    suspend fun getAll(): List<DeliveryTimeWindow>
    suspend fun getById(id: String): DeliveryTimeWindow?
    suspend fun getByChefId(chefId: String): List<DeliveryTimeWindow>
    suspend fun insert(window: DeliveryTimeWindow): DeliveryTimeWindow?
    suspend fun update(id: String, window: DeliveryTimeWindow): DeliveryTimeWindow?
    suspend fun delete(id: String)
} 
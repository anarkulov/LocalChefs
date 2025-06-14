package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.DeliveryTimeWindowApi
import org.localchefs.app.shared.domain.model.DeliveryTimeWindow
import org.localchefs.app.shared.domain.repository.DeliveryTimeWindowRepository

class DeliveryTimeWindowRepositoryImpl(private val api: DeliveryTimeWindowApi) : DeliveryTimeWindowRepository {
    override suspend fun getAll(): List<DeliveryTimeWindow> = api.getAll()
    override suspend fun getById(id: String): DeliveryTimeWindow? = api.getById(id)
    override suspend fun getByChefId(chefId: String): List<DeliveryTimeWindow> = api.getByChefId(chefId)
    override suspend fun insert(window: DeliveryTimeWindow): DeliveryTimeWindow? = api.insert(window)
    override suspend fun update(id: String, window: DeliveryTimeWindow): DeliveryTimeWindow? = api.update(id, window)
    override suspend fun delete(id: String) = api.delete(id)
} 
package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.AvailableDishApi
import org.localchefs.app.shared.domain.model.AvailableDish
import org.localchefs.app.shared.domain.repository.AvailableDishRepository

class AvailableDishRepositoryImpl(private val api: AvailableDishApi) : AvailableDishRepository {
    override suspend fun getAll(): List<AvailableDish> = api.getAll()
    override suspend fun getById(id: String): AvailableDish? = api.getById(id)
    override suspend fun insert(availableDish: AvailableDish): AvailableDish? = api.insert(availableDish)
    override suspend fun update(id: String, availableDish: AvailableDish): AvailableDish? = api.update(id, availableDish)
    override suspend fun delete(id: String) = api.delete(id)
} 
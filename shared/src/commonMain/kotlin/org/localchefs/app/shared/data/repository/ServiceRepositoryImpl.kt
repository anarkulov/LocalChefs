package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.ServiceApi
import org.localchefs.app.shared.domain.model.Service
import org.localchefs.app.shared.domain.repository.ServiceRepository

class ServiceRepositoryImpl(private val api: ServiceApi) : ServiceRepository {
    override suspend fun getAll(): List<Service> = api.getAll()
    override suspend fun getById(id: String): Service? = api.getById(id)
    override suspend fun insert(service: Service): Service? = api.insert(service)
    override suspend fun update(id: String, service: Service): Service? = api.update(id, service)
    override suspend fun delete(id: String) = api.delete(id)
} 
package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.Service

interface ServiceRepository {
    suspend fun getAll(): List<Service>
    suspend fun getById(id: String): Service?
    suspend fun insert(service: Service): Service?
    suspend fun update(id: String, service: Service): Service?
    suspend fun delete(id: String)
} 
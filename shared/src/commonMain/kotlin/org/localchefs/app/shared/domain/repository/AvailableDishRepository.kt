package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.AvailableDish

interface AvailableDishRepository {
    suspend fun getAll(): List<AvailableDish>
    suspend fun getById(id: String): AvailableDish?
    suspend fun insert(availableDish: AvailableDish): AvailableDish?
    suspend fun update(id: String, availableDish: AvailableDish): AvailableDish?
    suspend fun delete(id: String)
} 
package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.ServiceCategory

interface ServiceCategoryRepository {
    suspend fun getAll(): List<ServiceCategory>
    suspend fun getBySlug(slug: String): ServiceCategory?
    suspend fun insert(category: ServiceCategory): ServiceCategory?
    suspend fun update(slug: String, category: ServiceCategory): ServiceCategory?
    suspend fun delete(slug: String)
} 
package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.ServiceCategoryApi
import org.localchefs.app.shared.domain.model.ServiceCategory
import org.localchefs.app.shared.domain.repository.ServiceCategoryRepository

class ServiceCategoryRepositoryImpl(private val api: ServiceCategoryApi) : ServiceCategoryRepository {
    override suspend fun getAll(): List<ServiceCategory> = api.getAll()
    override suspend fun getBySlug(slug: String): ServiceCategory? = api.getBySlug(slug)
    override suspend fun insert(category: ServiceCategory): ServiceCategory? = api.insert(category)
    override suspend fun update(slug: String, category: ServiceCategory): ServiceCategory? = api.update(slug, category)
    override suspend fun delete(slug: String) = api.delete(slug)
} 
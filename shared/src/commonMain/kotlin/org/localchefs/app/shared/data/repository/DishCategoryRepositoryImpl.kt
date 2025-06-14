package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.DishCategoryApi
import org.localchefs.app.shared.domain.model.DishCategory
import org.localchefs.app.shared.domain.repository.DishCategoryRepository

class DishCategoryRepositoryImpl(private val api: DishCategoryApi) : DishCategoryRepository {
    override suspend fun getAll(): List<DishCategory> = api.getAll()
    override suspend fun getById(id: Int): DishCategory? = api.getById(id)
    override suspend fun insert(category: DishCategory): DishCategory? = api.insert(category)
    override suspend fun update(id: Int, category: DishCategory): DishCategory? = api.update(id, category)
    override suspend fun delete(id: Int) = api.delete(id)
} 
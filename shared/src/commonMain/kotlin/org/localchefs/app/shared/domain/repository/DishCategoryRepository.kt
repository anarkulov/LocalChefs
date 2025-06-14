package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.DishCategory

interface DishCategoryRepository {
    suspend fun getAll(): List<DishCategory>
    suspend fun getById(id: Int): DishCategory?
    suspend fun insert(category: DishCategory): DishCategory?
    suspend fun update(id: Int, category: DishCategory): DishCategory?
    suspend fun delete(id: Int)
} 
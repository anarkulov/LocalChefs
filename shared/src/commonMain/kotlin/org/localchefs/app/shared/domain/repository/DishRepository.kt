package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.Dish

interface DishRepository {
    suspend fun getAll(): List<Dish>
    suspend fun getById(id: String): Dish?
    suspend fun insert(dish: Dish): Dish?
    suspend fun update(id: String, dish: Dish): Dish?
    suspend fun delete(id: String)
} 
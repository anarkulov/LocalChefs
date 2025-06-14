package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.DishApi
import org.localchefs.app.shared.domain.model.Dish
import org.localchefs.app.shared.domain.repository.DishRepository

class DishRepositoryImpl(private val api: DishApi) : DishRepository {
    override suspend fun getAll(): List<Dish> = api.getAll()
    override suspend fun getById(id: String): Dish? = api.getById(id)
    override suspend fun insert(dish: Dish): Dish? = api.insert(dish)
    override suspend fun update(id: String, dish: Dish): Dish? = api.update(id, dish)
    override suspend fun delete(id: String) = api.delete(id)
} 
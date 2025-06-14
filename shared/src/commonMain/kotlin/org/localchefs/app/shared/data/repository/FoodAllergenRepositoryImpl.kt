package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.FoodAllergenApi
import org.localchefs.app.shared.domain.model.FoodAllergen
import org.localchefs.app.shared.domain.repository.FoodAllergenRepository

class FoodAllergenRepositoryImpl(private val api: FoodAllergenApi) : FoodAllergenRepository {
    override suspend fun getAll(): List<FoodAllergen> = api.getAll()
    override suspend fun getById(id: String): FoodAllergen? = api.getById(id)
    override suspend fun insert(foodAllergen: FoodAllergen): FoodAllergen? = api.insert(foodAllergen)
    override suspend fun update(id: String, foodAllergen: FoodAllergen): FoodAllergen? = api.update(id, foodAllergen)
    override suspend fun delete(id: String) = api.delete(id)
} 
package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.FoodAllergen

interface FoodAllergenRepository {
    suspend fun getAll(): List<FoodAllergen>
    suspend fun getById(id: String): FoodAllergen?
    suspend fun insert(foodAllergen: FoodAllergen): FoodAllergen?
    suspend fun update(id: String, foodAllergen: FoodAllergen): FoodAllergen?
    suspend fun delete(id: String)
} 
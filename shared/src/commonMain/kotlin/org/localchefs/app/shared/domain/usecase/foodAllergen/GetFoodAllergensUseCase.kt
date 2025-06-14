package org.localchefs.app.shared.domain.usecase.foodAllergen

import org.localchefs.app.shared.domain.model.FoodAllergen
import org.localchefs.app.shared.domain.repository.FoodAllergenRepository

class GetFoodAllergensUseCase(private val repository: FoodAllergenRepository) {
    suspend operator fun invoke(): List<FoodAllergen> = repository.getAll()
} 
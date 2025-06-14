package org.localchefs.app.shared.domain.usecase.dish

import org.localchefs.app.shared.domain.model.Dish
import org.localchefs.app.shared.domain.repository.DishRepository

class GetDishesUseCase(private val repository: DishRepository) {
    suspend operator fun invoke(): List<Dish> = repository.getAll()
} 
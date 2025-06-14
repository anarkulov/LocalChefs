package org.localchefs.app.shared.domain.usecase.dishCategory

import org.localchefs.app.shared.domain.model.DishCategory
import org.localchefs.app.shared.domain.repository.DishCategoryRepository

class GetDishCategoriesUseCase(private val repository: DishCategoryRepository) {
    suspend operator fun invoke(): List<DishCategory> = repository.getAll()
} 
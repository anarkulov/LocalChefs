package org.localchefs.app.shared.domain.usecase.dietaryTag

import org.localchefs.app.shared.domain.model.DietaryTag
import org.localchefs.app.shared.domain.repository.DietaryTagRepository

class GetDietaryTagsUseCase(private val repository: DietaryTagRepository) {
    suspend operator fun invoke(): List<DietaryTag> = repository.getAll()
} 
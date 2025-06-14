package org.localchefs.app.shared.domain.usecase.chefProfile

import org.localchefs.app.shared.domain.model.ChefProfile
import org.localchefs.app.shared.domain.repository.ChefProfileRepository

class GetChefByIdUseCase(private val repository: ChefProfileRepository) {
    suspend operator fun invoke(id: String): ChefProfile? = repository.getChefById(id)
} 
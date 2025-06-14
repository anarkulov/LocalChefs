package org.localchefs.app.shared.domain.usecase.chefProfile

import org.localchefs.app.shared.domain.model.ChefProfile
import org.localchefs.app.shared.domain.repository.ChefProfileRepository

class GetChefsUseCase(private val repository: ChefProfileRepository) {
    suspend operator fun invoke(): List<ChefProfile> = repository.getChefs()
} 
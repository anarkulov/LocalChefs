package org.localchefs.app.shared.domain.usecase.chefProfile

import org.localchefs.app.shared.domain.model.ChefProfile
import org.localchefs.app.shared.domain.repository.ChefProfileRepository

class GetChefsByLocationUseCase(private val repository: ChefProfileRepository) {
    suspend operator fun invoke(
        latitude: Float,
        longitude: Float,
        radiusMiles: Int
    ): List<ChefProfile> = repository.getChefsByLocation(
        latitude = latitude,
        longitude = longitude,
        radiusMiles = radiusMiles
    )
} 
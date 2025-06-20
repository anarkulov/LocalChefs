package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.ChefProfileApi
import org.localchefs.app.shared.domain.model.ChefProfile
import org.localchefs.app.shared.domain.repository.ChefProfileRepository

class ChefProfileRepositoryImpl(private val api: ChefProfileApi) : ChefProfileRepository {
    override suspend fun getChefs(): List<ChefProfile> = api.getChefs()
    override suspend fun getChefById(id: String): ChefProfile? = api.getChefById(id)
    override suspend fun getChefsByLocation(
        latitude: Float,
        longitude: Float,
        radiusMiles: Int
    ): List<ChefProfile> = api.getChefsByLocation(latitude, longitude, radiusMiles)
    override suspend fun updateChefProfile(id: String, data: ChefProfile): ChefProfile? =
        api.updateChefProfile(id, data)
} 
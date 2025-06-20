package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.ChefProfile

interface ChefProfileRepository {
    suspend fun getChefs(): List<ChefProfile>
    suspend fun getChefById(id: String): ChefProfile?
    suspend fun getChefsByLocation(latitude: Float, longitude: Float, radiusMiles: Int): List<ChefProfile>
    suspend fun updateChefProfile(id: String, data: ChefProfile): ChefProfile?
} 
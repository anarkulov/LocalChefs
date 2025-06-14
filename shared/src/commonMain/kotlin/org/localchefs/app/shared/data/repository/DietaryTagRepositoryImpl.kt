package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.DietaryTagApi
import org.localchefs.app.shared.domain.model.DietaryTag
import org.localchefs.app.shared.domain.repository.DietaryTagRepository

class DietaryTagRepositoryImpl(private val api: DietaryTagApi) : DietaryTagRepository {
    override suspend fun getAll(): List<DietaryTag> = api.getAll()
    override suspend fun getById(id: String): DietaryTag? = api.getById(id)
    override suspend fun insert(dietaryTag: DietaryTag): DietaryTag? = api.insert(dietaryTag)
    override suspend fun update(id: String, dietaryTag: DietaryTag): DietaryTag? = api.update(id, dietaryTag)
    override suspend fun delete(id: String) = api.delete(id)
} 
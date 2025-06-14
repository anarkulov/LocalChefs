package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.DietaryTag

interface DietaryTagRepository {
    suspend fun getAll(): List<DietaryTag>
    suspend fun getById(id: String): DietaryTag?
    suspend fun insert(dietaryTag: DietaryTag): DietaryTag?
    suspend fun update(id: String, dietaryTag: DietaryTag): DietaryTag?
    suspend fun delete(id: String)
} 
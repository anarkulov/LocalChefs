package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.Review

interface ReviewRepository {
    suspend fun getAll(): List<Review>
    suspend fun getById(id: String): Review?
    suspend fun getByChefId(id: String): Review?
    suspend fun insert(review: Review): Review?
    suspend fun update(id: String, review: Review): Review?
    suspend fun delete(id: String)
} 
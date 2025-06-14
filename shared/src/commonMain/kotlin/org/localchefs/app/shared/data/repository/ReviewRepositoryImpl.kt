package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.ReviewApi
import org.localchefs.app.shared.domain.model.Review
import org.localchefs.app.shared.domain.repository.ReviewRepository

class ReviewRepositoryImpl(private val api: ReviewApi) : ReviewRepository {
    override suspend fun getAll(): List<Review> = api.getAll()
    override suspend fun getById(id: String): Review? = api.getById(id)
    override suspend fun insert(review: Review): Review? = api.insert(review)
    override suspend fun update(id: String, review: Review): Review? = api.update(id, review)
    override suspend fun delete(id: String) = api.delete(id)
} 
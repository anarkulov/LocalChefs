package org.localchefs.app.shared.domain.usecase.review

import org.localchefs.app.shared.domain.model.Review
import org.localchefs.app.shared.domain.repository.ReviewRepository

class GetReviewsUseCase(private val repository: ReviewRepository) {
    suspend operator fun invoke(): List<Review> = repository.getAll()
} 
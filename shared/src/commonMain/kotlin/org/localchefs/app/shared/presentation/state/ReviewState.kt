package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.Review

data class ReviewState(
    val reviews: List<Review> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
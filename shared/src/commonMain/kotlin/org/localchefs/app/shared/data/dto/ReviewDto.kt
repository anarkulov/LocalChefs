package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ReviewDto(
    val id: String,
    val chef_id: String,
    val chef_reply: String? = null,
    val chef_reply_at: String? = null,
    val comment: String? = null,
    val created_at: String,
    val order_id: String,
    val rating: Double,
    val reviewer_id: String,
    val tags: List<String>? = null
) 
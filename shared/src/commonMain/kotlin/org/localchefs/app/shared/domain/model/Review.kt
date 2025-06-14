package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Review(
    val id: String,
    val chefId: String,
    val chefReply: String? = null,
    val chefReplyAt: String? = null,
    val comment: String? = null,
    val createdAt: String,
    val orderId: String,
    val rating: Double,
    val reviewerId: String,
    val tags: List<String>? = null
) 
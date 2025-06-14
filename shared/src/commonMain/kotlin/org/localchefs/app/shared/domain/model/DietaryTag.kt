package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class DietaryTag(
    val id: String,
    val tagName: String,
    val displayName: String,
    val description: String,
    val shortcode: String? = null,
    val createdAt: String,
    val updatedAt: String
) 
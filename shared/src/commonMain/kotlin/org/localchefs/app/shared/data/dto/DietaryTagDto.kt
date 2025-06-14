package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class DietaryTagDto(
    val id: String,
    val tag_name: String,
    val display_name: String,
    val description: String,
    val shortcode: String? = null,
    val created_at: String,
    val updated_at: String
) 
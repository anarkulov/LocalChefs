package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class DishCategoryDto(
    val description: String? = null,
    val id: Int,
    val name: String,
    val slug: String? = null
) 
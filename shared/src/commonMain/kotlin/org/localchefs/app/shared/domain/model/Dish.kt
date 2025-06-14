package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Dish(
    val id: String,
    val chefId: String,
    val createdAt: String? = null,
    val description: String? = null,
    val dietaryTags: List<String>? = null,
    val dishCategoryId: Int? = null,
    val imageUrl: String? = null,
    val isActive: Boolean? = null,
    val minOrderAmount: Double? = null,
    val name: String,
    val price: Double,
    val updatedAt: String? = null
) 
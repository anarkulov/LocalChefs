package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class DishDto(
    val id: String,
    val chef_id: String,
    val created_at: String? = null,
    val description: String? = null,
    val dietary_tags: List<String>? = null,
    val dish_category_id: Int? = null,
    val image_url: String? = null,
    val is_active: Boolean? = null,
    val min_order_amount: Double? = null,
    val name: String,
    val price: Double,
    val updated_at: String? = null
) 
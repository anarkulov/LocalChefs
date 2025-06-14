package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class AvailableDishDto(
    val id: String,
    val available_date: String,
    val chef_id: String,
    val created_at: String,
    val dish_id: String,
    val notes: String? = null,
    val quantity_available: Int
) 
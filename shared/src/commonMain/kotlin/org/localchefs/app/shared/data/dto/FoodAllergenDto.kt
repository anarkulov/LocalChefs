package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class FoodAllergenDto(
    val allergen_name: String,
    val created_at: String,
    val description: String,
    val examples: String,
    val id: String,
    val updated_at: String
) 
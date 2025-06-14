package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class FoodAllergen(
    val allergenName: String,
    val createdAt: String,
    val description: String,
    val examples: String,
    val id: String,
    val updatedAt: String
) 
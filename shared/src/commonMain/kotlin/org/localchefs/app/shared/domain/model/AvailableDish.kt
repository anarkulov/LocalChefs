package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AvailableDish(
    val id: String,
    val availableDate: String,
    val chefId: String,
    val createdAt: String,
    val dishId: String,
    val notes: String? = null,
    val quantityAvailable: Int
) 
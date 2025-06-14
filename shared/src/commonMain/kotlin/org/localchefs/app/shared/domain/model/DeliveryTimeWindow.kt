package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class DeliveryTimeWindow(
    val chefId: String,
    val createdAt: String,
    val endTime: String,
    val id: String,
    val startTime: String,
    val updatedAt: String
) 
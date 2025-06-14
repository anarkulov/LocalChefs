package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class DeliveryTimeWindowDto(
    val chef_id: String,
    val created_at: String,
    val end_time: String,
    val id: String,
    val start_time: String,
    val updated_at: String
) 
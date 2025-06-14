package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ServiceDto(
    val id: String,
    val chef_id: String,
    val name: String,
    val description: String,
    val price: Double,
    val duration: Int,
    val category: String,
    val created_at: String,
    val updated_at: String
) 
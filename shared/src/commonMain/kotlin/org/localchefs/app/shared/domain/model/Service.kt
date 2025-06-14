package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Service(
    val id: String,
    val chefId: String,
    val name: String,
    val description: String,
    val price: Double,
    val duration: Int,
    val category: String,
    val createdAt: String,
    val updatedAt: String
) 
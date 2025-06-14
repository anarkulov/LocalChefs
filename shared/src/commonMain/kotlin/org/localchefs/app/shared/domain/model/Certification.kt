package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Certification(
    val certificateNumber: String,
    val chefId: String,
    val createdAt: String,
    val documentUrl: String,
    val expiresAt: String? = null,
    val id: String,
    val issuedAt: String,
    val type: String,
    val updatedAt: String,
    val verified: Boolean
)
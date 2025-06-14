package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CertificationDto(
    val certificate_number: String,
    val chef_id: String,
    val created_at: String,
    val document_url: String,
    val expires_at: String? = null,
    val id: String,
    val issued_at: String,
    val type: String,
    val updated_at: String,
    val verified: Boolean
) 
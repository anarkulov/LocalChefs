package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProteinDto(
    val id: String,
    val name: String,
    val created_at: String,
    val updated_at: String
) 
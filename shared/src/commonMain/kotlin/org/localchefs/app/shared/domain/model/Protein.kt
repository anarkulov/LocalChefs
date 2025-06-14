package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Protein(
    val id: String,
    val name: String,
    val createdAt: String,
    val updatedAt: String
) 
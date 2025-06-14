package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class OptionChoice(
    val id: String,
    val groupId: String,
    val name: String,
    val additionalPrice: Double? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
) 
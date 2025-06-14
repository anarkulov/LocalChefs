package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class OptionGroup(
    val id: String,
    val dishId: String,
    val name: String,
    val minSelections: Int? = null,
    val maxSelections: Int? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
) 
package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class DishCategory(
    val description: String? = null,
    val id: Int,
    val name: String,
    val slug: String? = null
) 
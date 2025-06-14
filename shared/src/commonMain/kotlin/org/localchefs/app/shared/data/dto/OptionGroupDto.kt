package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class OptionGroupDto(
    val id: String,
    val dish_id: String,
    val name: String,
    val min_selections: Int? = null,
    val max_selections: Int? = null,
    val created_at: String? = null,
    val updated_at: String? = null
) 
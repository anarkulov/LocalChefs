package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class OptionChoiceDto(
    val id: String,
    val group_id: String,
    val name: String,
    val additional_price: Double? = null,
    val created_at: String? = null,
    val updated_at: String? = null
) 
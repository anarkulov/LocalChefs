package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class StateDto(
    val id: String,
    val name: String,
    val abbreviation: String
) 
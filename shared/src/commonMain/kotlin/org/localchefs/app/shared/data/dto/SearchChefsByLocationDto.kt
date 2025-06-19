package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class SearchChefsByLocationDto(
    val latitude: Double,
    val longitude: Double,
    val radiusMiles: Int
)

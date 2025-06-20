package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class SearchChefsByLocationDto(
    val search_lat: Float,
    val search_lng: Float,
    val radius_meters: Int
)

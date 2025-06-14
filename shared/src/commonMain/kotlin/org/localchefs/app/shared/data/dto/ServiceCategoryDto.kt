package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ServiceCategoryDto(
    val display_name: String,
    val slug: String
) 
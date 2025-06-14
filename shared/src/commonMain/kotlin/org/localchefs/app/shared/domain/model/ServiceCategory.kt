package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ServiceCategory(
    val displayName: String,
    val slug: String
) 
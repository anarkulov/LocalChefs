package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CertificationTypeDto(
    val description: String? = null,
    val name: String,
    val required: Boolean,
    val slug: String
) 
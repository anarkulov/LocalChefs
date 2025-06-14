package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CertificationType(
    val description: String? = null,
    val name: String,
    val required: Boolean,
    val slug: String
) 
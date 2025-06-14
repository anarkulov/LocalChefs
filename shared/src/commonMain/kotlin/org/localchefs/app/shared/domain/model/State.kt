package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class State(
    val id: String,
    val name: String,
    val abbreviation: String
) 
package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Profile(
    val id: String,
    val allergies: List<String>? = null,
    val avatarUrl: String? = null,
    val city: String? = null,
    val createdAt: String? = null,
    val deactivatedAt: String? = null,
    val deliveryAddress: String? = null,
    val email: String? = null,
    val isActive: Boolean? = null,
    val location: JsonElement? = null,
    val name: String? = null,
    val notificationPreferences: JsonElement? = null,
    val phone: String? = null,
    val role: String,
    val state: String? = null,
    val updatedAt: String? = null,
    val zipCode: String? = null
) 
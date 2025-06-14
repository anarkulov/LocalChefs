package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class ProfileDto(
    val id: String,
    val allergies: List<String>? = null,
    val avatar_url: String? = null,
    val city: String? = null,
    val created_at: String? = null,
    val deactivated_at: String? = null,
    val delivery_address: String? = null,
    val email: String? = null,
    val is_active: Boolean? = null,
    val location: JsonElement? = null,
    val name: String? = null,
    val notification_preferences: JsonElement? = null,
    val phone: String? = null,
    val role: String,
    val state: String? = null,
    val updated_at: String? = null,
    val zip_code: String? = null
) 
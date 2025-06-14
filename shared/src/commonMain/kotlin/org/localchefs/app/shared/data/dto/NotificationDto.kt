package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class NotificationDto(
    val id: String,
    val user_id: String,
    val triggered_by: String? = null,
    val title: String,
    val message: String,
    val type: String? = null,
    val data: JsonElement? = null,
    val is_read: Boolean? = null,
    val email_sent: Boolean? = null,
    val email_sent_at: String? = null,
    val actionlink: String? = null,
    val actiontext: String? = null,
    val created_at: String? = null
) 
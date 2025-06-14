package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Notification(
    val id: String,
    val userId: String,
    val triggeredBy: String? = null,
    val title: String,
    val message: String,
    val type: String? = null,
    val data: JsonElement? = null,
    val isRead: Boolean? = null,
    val emailSent: Boolean? = null,
    val emailSentAt: String? = null,
    val actionLink: String? = null,
    val actionText: String? = null,
    val createdAt: String? = null
) 
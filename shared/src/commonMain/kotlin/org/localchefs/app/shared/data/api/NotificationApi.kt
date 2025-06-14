package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.NotificationDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.Notification

class NotificationApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<Notification> {
        val result = supabaseClient.from("notifications").select().decodeList<NotificationDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): Notification? {
        val result = supabaseClient.from("notifications").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<NotificationDto>()
        return result?.toDomain()
    }

    suspend fun getByUserId(userId: String): List<Notification> {
        val result = supabaseClient.from("notifications").select {
            filter { eq("user_id", userId) }
        }.decodeList<NotificationDto>()
        return result.map { it.toDomain() }
    }

    suspend fun insert(notification: Notification): Notification? {
        val dto = notification.toDto()
        val result = supabaseClient.from("notifications").insert(dto).decodeSingleOrNull<NotificationDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, notification: Notification): Notification? {
        val result = supabaseClient.from("notifications").update(notification.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<NotificationDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("notifications").delete {
            filter { eq("id", id) }
        }
    }
} 
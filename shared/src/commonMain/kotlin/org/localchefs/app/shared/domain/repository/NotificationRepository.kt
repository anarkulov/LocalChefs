package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.Notification

interface NotificationRepository {
    suspend fun getAll(): List<Notification>
    suspend fun getById(id: String): Notification?
    suspend fun getByUserId(userId: String): List<Notification>
    suspend fun insert(notification: Notification): Notification?
    suspend fun update(id: String, notification: Notification): Notification?
    suspend fun delete(id: String)
} 
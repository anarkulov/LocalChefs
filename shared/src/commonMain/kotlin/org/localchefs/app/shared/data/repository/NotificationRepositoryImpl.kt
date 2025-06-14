package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.NotificationApi
import org.localchefs.app.shared.domain.model.Notification
import org.localchefs.app.shared.domain.repository.NotificationRepository

class NotificationRepositoryImpl(private val api: NotificationApi) : NotificationRepository {
    override suspend fun getAll(): List<Notification> = api.getAll()
    override suspend fun getById(id: String): Notification? = api.getById(id)
    override suspend fun getByUserId(userId: String): List<Notification> = api.getByUserId(userId)
    override suspend fun insert(notification: Notification): Notification? = api.insert(notification)
    override suspend fun update(id: String, notification: Notification): Notification? = api.update(id, notification)
    override suspend fun delete(id: String) = api.delete(id)
} 
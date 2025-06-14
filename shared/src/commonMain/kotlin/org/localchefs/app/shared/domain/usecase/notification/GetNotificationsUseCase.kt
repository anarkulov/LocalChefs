package org.localchefs.app.shared.domain.usecase.notification

import org.localchefs.app.shared.domain.model.Notification
import org.localchefs.app.shared.domain.repository.NotificationRepository

class GetNotificationsUseCase(private val repository: NotificationRepository) {
    suspend operator fun invoke(): List<Notification> = repository.getAll()
} 
package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.NotificationDto
import org.localchefs.app.shared.domain.model.Notification

fun NotificationDto.toDomain(): Notification = Notification(
    id = id,
    userId = user_id,
    triggeredBy = triggered_by,
    title = title,
    message = message,
    type = type,
    data = data,
    isRead = is_read,
    emailSent = email_sent,
    emailSentAt = email_sent_at,
    actionLink = actionlink,
    actionText = actiontext,
    createdAt = created_at
)

fun Notification.toDto(): NotificationDto = NotificationDto(
    id = id,
    user_id = userId,
    triggered_by = triggeredBy,
    title = title,
    message = message,
    type = type,
    data = data,
    is_read = isRead,
    email_sent = emailSent,
    email_sent_at = emailSentAt,
    actionlink = actionLink,
    actiontext = actionText,
    created_at = createdAt
) 
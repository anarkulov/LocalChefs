package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.Notification

data class NotificationState(
    val notifications: List<Notification> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
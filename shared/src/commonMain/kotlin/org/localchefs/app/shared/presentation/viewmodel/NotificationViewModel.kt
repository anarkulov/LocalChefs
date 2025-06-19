package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.localchefs.app.shared.domain.usecase.notification.GetNotificationsUseCase
import org.localchefs.app.shared.domain.usecase.notification.GetNotificationsByUserIdUseCase
import org.localchefs.app.shared.presentation.state.NotificationState

class NotificationViewModel(
    private val getNotificationsUseCase: GetNotificationsUseCase,
    private val getNotificationsByUserIdUseCase: GetNotificationsByUserIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(NotificationState())
    @NativeCoroutinesState
    val state: StateFlow<NotificationState> = _state.asStateFlow()

    fun loadNotifications() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val notifications = getNotificationsUseCase()
                _state.update { it.copy(isLoading = false, notifications = notifications) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun loadNotificationsByUserId(userId: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val notifications = getNotificationsByUserIdUseCase(userId)
                _state.update { it.copy(isLoading = false, notifications = notifications) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
} 
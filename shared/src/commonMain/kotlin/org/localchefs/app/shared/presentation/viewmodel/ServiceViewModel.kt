package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.service.GetServicesUseCase
import org.localchefs.app.shared.presentation.state.ServiceState

class ServiceViewModel(
    private val getServicesUseCase: GetServicesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ServiceState())
    val state: StateFlow<ServiceState> = _state.asStateFlow()

    fun loadServices() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val services = getServicesUseCase()
                _state.value = ServiceState(services = services, isLoading = false)
            } catch (e: Exception) {
                _state.value = ServiceState(isLoading = false, error = e.message)
            }
        }
    }
} 
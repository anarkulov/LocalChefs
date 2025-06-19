package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.localchefs.app.shared.domain.usecase.delivery.GetDeliveryTimeWindowsUseCase
import org.localchefs.app.shared.domain.usecase.delivery.GetDeliveryTimeWindowsByChefIdUseCase
import org.localchefs.app.shared.presentation.state.DeliveryTimeWindowState

class DeliveryTimeWindowViewModel(
    private val getDeliveryTimeWindowsUseCase: GetDeliveryTimeWindowsUseCase,
    private val getDeliveryTimeWindowsByChefIdUseCase: GetDeliveryTimeWindowsByChefIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(DeliveryTimeWindowState())
    @NativeCoroutinesState
    val state: StateFlow<DeliveryTimeWindowState> = _state.asStateFlow()

    fun loadDeliveryTimeWindows() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val windows = getDeliveryTimeWindowsUseCase()
                _state.update { it.copy(isLoading = false, deliveryTimeWindows = windows) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun loadDeliveryTimeWindowsByChefId(chefId: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val windows = getDeliveryTimeWindowsByChefIdUseCase(chefId)
                _state.update { it.copy(isLoading = false, deliveryTimeWindows = windows) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
} 
package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.order.GetOrdersUseCase
import org.localchefs.app.shared.presentation.state.OrderState

class OrderViewModel(
    private val getOrdersUseCase: GetOrdersUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(OrderState())
    val state: StateFlow<OrderState> = _state.asStateFlow()

    fun loadOrders() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val orders = getOrdersUseCase()
                _state.value = OrderState(orders = orders, isLoading = false)
            } catch (e: Exception) {
                _state.value = OrderState(isLoading = false, error = e.message)
            }
        }
    }
} 
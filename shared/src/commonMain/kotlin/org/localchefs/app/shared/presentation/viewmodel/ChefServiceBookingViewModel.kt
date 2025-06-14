package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.serviceBooking.GetChefServiceBookingsUseCase
import org.localchefs.app.shared.presentation.state.ChefServiceBookingState

class ChefServiceBookingViewModel(
    private val getChefServiceBookingsUseCase: GetChefServiceBookingsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ChefServiceBookingState())
    val state: StateFlow<ChefServiceBookingState> = _state.asStateFlow()

    fun loadBookings() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val bookings = getChefServiceBookingsUseCase()
                _state.value = ChefServiceBookingState(bookings = bookings, isLoading = false)
            } catch (e: Exception) {
                _state.value = ChefServiceBookingState(isLoading = false, error = e.message)
            }
        }
    }
} 
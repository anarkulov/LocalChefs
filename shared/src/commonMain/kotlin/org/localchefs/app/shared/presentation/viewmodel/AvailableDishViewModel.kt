package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.availableDish.GetAvailableDishesUseCase
import org.localchefs.app.shared.presentation.state.AvailableDishState

class AvailableDishViewModel(
    private val getAvailableDishesUseCase: GetAvailableDishesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(AvailableDishState())
    val state: StateFlow<AvailableDishState> = _state.asStateFlow()

    fun loadAvailableDishes() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val availableDishes = getAvailableDishesUseCase()
                _state.value = AvailableDishState(availableDishes = availableDishes, isLoading = false)
            } catch (e: Exception) {
                _state.value = AvailableDishState(isLoading = false, error = e.message)
            }
        }
    }
} 
package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.state.GetStatesUseCase
import org.localchefs.app.shared.presentation.state.StateState

class StateViewModel(
    private val getStatesUseCase: GetStatesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(StateState())
    val state: StateFlow<StateState> = _state.asStateFlow()

    fun loadStates() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val states = getStatesUseCase()
                _state.value = StateState(states = states, isLoading = false)
            } catch (e: Exception) {
                _state.value = StateState(isLoading = false, error = e.message)
            }
        }
    }
} 
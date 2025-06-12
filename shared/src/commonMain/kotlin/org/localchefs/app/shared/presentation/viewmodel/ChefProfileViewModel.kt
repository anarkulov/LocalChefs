package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.GetChefsUseCase
import org.localchefs.app.shared.presentation.state.ChefProfileState

class ChefProfileViewModel(
    private val getChefsUseCase: GetChefsUseCase
) : BaseViewModel() {
    private val _state = MutableStateFlow(ChefProfileState())
    val state: StateFlow<ChefProfileState> = _state.asStateFlow()

    fun loadChefs() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val chefs = getChefsUseCase()
                _state.value = ChefProfileState(chefs = chefs, isLoading = false)
            } catch (e: Exception) {
                _state.value = ChefProfileState(isLoading = false, error = e.message)
            }
        }
    }
} 
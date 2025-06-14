package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.dish.GetDishesUseCase
import org.localchefs.app.shared.presentation.state.DishState

class DishViewModel(
    private val getDishesUseCase: GetDishesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(DishState())
    val state: StateFlow<DishState> = _state.asStateFlow()

    fun loadDishes() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val dishes = getDishesUseCase()
                _state.value = DishState(dishes = dishes, isLoading = false)
            } catch (e: Exception) {
                _state.value = DishState(isLoading = false, error = e.message)
            }
        }
    }
} 
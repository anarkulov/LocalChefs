package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.foodAllergen.GetFoodAllergensUseCase
import org.localchefs.app.shared.presentation.state.FoodAllergenState

class FoodAllergenViewModel(
    private val getFoodAllergensUseCase: GetFoodAllergensUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(FoodAllergenState())
    val state: StateFlow<FoodAllergenState> = _state.asStateFlow()

    fun loadFoodAllergens() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val foodAllergens = getFoodAllergensUseCase()
                _state.value = FoodAllergenState(foodAllergens = foodAllergens, isLoading = false)
            } catch (e: Exception) {
                _state.value = FoodAllergenState(isLoading = false, error = e.message)
            }
        }
    }
} 
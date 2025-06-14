package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.dishCategory.GetDishCategoriesUseCase
import org.localchefs.app.shared.presentation.state.DishCategoryState

class DishCategoryViewModel(
    private val getDishCategoriesUseCase: GetDishCategoriesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(DishCategoryState())
    val state: StateFlow<DishCategoryState> = _state.asStateFlow()

    fun loadCategories() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val categories = getDishCategoriesUseCase()
                _state.value = DishCategoryState(categories = categories, isLoading = false)
            } catch (e: Exception) {
                _state.value = DishCategoryState(isLoading = false, error = e.message)
            }
        }
    }
} 
package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.serviceCategory.GetServiceCategoriesUseCase
import org.localchefs.app.shared.presentation.state.ServiceCategoryState

class ServiceCategoryViewModel(
    private val getServiceCategoriesUseCase: GetServiceCategoriesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ServiceCategoryState())
    val state: StateFlow<ServiceCategoryState> = _state.asStateFlow()

    fun loadCategories() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val categories = getServiceCategoriesUseCase()
                _state.value = ServiceCategoryState(categories = categories, isLoading = false)
            } catch (e: Exception) {
                _state.value = ServiceCategoryState(isLoading = false, error = e.message)
            }
        }
    }
} 
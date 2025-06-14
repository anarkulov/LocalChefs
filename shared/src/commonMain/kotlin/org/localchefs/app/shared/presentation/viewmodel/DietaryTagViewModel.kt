package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.dietaryTag.GetDietaryTagsUseCase
import org.localchefs.app.shared.presentation.state.DietaryTagState

class DietaryTagViewModel(
    private val getDietaryTagsUseCase: GetDietaryTagsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(DietaryTagState())
    val state: StateFlow<DietaryTagState> = _state.asStateFlow()

    fun loadDietaryTags() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val dietaryTags = getDietaryTagsUseCase()
                _state.value = DietaryTagState(dietaryTags = dietaryTags, isLoading = false)
            } catch (e: Exception) {
                _state.value = DietaryTagState(isLoading = false, error = e.message)
            }
        }
    }
} 
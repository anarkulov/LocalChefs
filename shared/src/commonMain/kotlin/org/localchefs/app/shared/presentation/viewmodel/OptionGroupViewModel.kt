package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.localchefs.app.shared.domain.usecase.option.GetOptionGroupsByDishIdUseCase
import org.localchefs.app.shared.domain.usecase.option.GetOptionGroupByIdUseCase
import org.localchefs.app.shared.domain.usecase.option.GetOptionGroupsUseCase
import org.localchefs.app.shared.presentation.state.OptionGroupState

class OptionGroupViewModel(
    private val getOptionGroupsUseCase: GetOptionGroupsUseCase,
    private val getOptionGroupByIdUseCase: GetOptionGroupByIdUseCase,
    private val getOptionGroupsByDishIdUseCase: GetOptionGroupsByDishIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(OptionGroupState())
    @NativeCoroutinesState
    val state: StateFlow<OptionGroupState> = _state.asStateFlow()

    fun loadOptionGroups() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val optionGroups = getOptionGroupsUseCase()
                _state.update { it.copy(isLoading = false, optionGroups = optionGroups) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun loadOptionGroupById(id: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val optionGroup = getOptionGroupByIdUseCase(id)
                _state.update { it.copy(isLoading = false, optionGroups = optionGroup?.let { listOf(it) } ?: emptyList()) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun loadOptionGroupsByDishId(dishId: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val optionGroups = getOptionGroupsByDishIdUseCase(dishId)
                _state.update { it.copy(isLoading = false, optionGroups = optionGroups) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
} 
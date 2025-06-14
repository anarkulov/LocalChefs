package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.localchefs.app.shared.domain.usecase.option.GetOptionChoicesByGroupIdUseCase
import org.localchefs.app.shared.domain.usecase.option.GetOptionChoiceByIdUseCase
import org.localchefs.app.shared.domain.usecase.option.GetOptionChoicesUseCase
import org.localchefs.app.shared.presentation.state.OptionChoiceState

class OptionChoiceViewModel(
    private val getOptionChoicesUseCase: GetOptionChoicesUseCase,
    private val getOptionChoiceByIdUseCase: GetOptionChoiceByIdUseCase,
    private val getOptionChoicesByGroupIdUseCase: GetOptionChoicesByGroupIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(OptionChoiceState())
    @NativeCoroutinesState
    val state: StateFlow<OptionChoiceState> = _state.asStateFlow()

    fun loadOptionChoices() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val optionChoices = getOptionChoicesUseCase()
                _state.update { it.copy(isLoading = false, optionChoices = optionChoices) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun loadOptionChoiceById(id: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val optionChoice = getOptionChoiceByIdUseCase(id)
                _state.update { it.copy(isLoading = false, optionChoices = optionChoice?.let { listOf(it) } ?: emptyList()) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun loadOptionChoicesByGroupId(groupId: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val optionChoices = getOptionChoicesByGroupIdUseCase(groupId)
                _state.update { it.copy(isLoading = false, optionChoices = optionChoices) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
} 
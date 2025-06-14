package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.localchefs.app.shared.domain.usecase.protein.GetProteinsUseCase
import org.localchefs.app.shared.domain.usecase.protein.GetProteinByIdUseCase
import org.localchefs.app.shared.presentation.state.ProteinState

class ProteinViewModel(
    private val getProteinsUseCase: GetProteinsUseCase,
    private val getProteinByIdUseCase: GetProteinByIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ProteinState())
    @NativeCoroutinesState
    val state: StateFlow<ProteinState> = _state.asStateFlow()

    fun loadProteins() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val proteins = getProteinsUseCase()
                _state.update { it.copy(isLoading = false, proteins = proteins) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun loadProteinById(id: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val protein = getProteinByIdUseCase(id)
                _state.update { it.copy(isLoading = false, proteins = protein?.let { listOf(it) } ?: emptyList()) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
} 
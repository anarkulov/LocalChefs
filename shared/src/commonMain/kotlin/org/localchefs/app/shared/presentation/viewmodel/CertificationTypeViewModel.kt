package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.localchefs.app.shared.domain.usecase.certification.GetCertificationTypesUseCase
import org.localchefs.app.shared.domain.usecase.certification.GetCertificationTypeBySlugUseCase
import org.localchefs.app.shared.presentation.state.CertificationTypeState

class CertificationTypeViewModel(
    private val getCertificationTypesUseCase: GetCertificationTypesUseCase,
    private val getCertificationTypeBySlugUseCase: GetCertificationTypeBySlugUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CertificationTypeState())
    @NativeCoroutinesState
    val state: StateFlow<CertificationTypeState> = _state.asStateFlow()

    fun loadCertificationTypes() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val types = getCertificationTypesUseCase()
                _state.update { it.copy(isLoading = false, certificationTypes = types) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun loadCertificationTypeBySlug(slug: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val type = getCertificationTypeBySlugUseCase(slug)
                _state.update { it.copy(isLoading = false, certificationTypes = type?.let { listOf(it) } ?: emptyList()) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
} 
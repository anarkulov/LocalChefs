package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.certification.GetCertificationsUseCase
import org.localchefs.app.shared.presentation.state.CertificationState

class CertificationViewModel(
    private val getCertificationsUseCase: GetCertificationsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CertificationState())
    val state: StateFlow<CertificationState> = _state.asStateFlow()

    fun loadCertifications() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val certifications = getCertificationsUseCase()
                _state.value = CertificationState(certifications = certifications, isLoading = false)
            } catch (e: Exception) {
                _state.value = CertificationState(isLoading = false, error = e.message)
            }
        }
    }
} 
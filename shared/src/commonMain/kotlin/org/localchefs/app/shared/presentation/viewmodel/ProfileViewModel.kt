package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.profile.GetProfilesUseCase
import org.localchefs.app.shared.presentation.state.ProfileState

class ProfileViewModel(
    private val getProfilesUseCase: GetProfilesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ProfileState())
    val state: StateFlow<ProfileState> = _state.asStateFlow()

    fun loadProfiles() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val profiles = getProfilesUseCase()
                _state.value = ProfileState(profiles = profiles, isLoading = false)
            } catch (e: Exception) {
                _state.value = ProfileState(isLoading = false, error = e.message)
            }
        }
    }
} 
package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.chefProfile.GetChefsByLocationUseCase
import org.localchefs.app.shared.domain.usecase.chefProfile.GetChefsUseCase
import org.localchefs.app.shared.presentation.state.ChefProfileState

class ChefProfileViewModel(
    private val getChefsUseCase: GetChefsUseCase,
    private val getChefsByLocationUseCase: GetChefsByLocationUseCase
) : BaseViewModel() {
    private val _state = MutableStateFlow(ChefProfileState())
    val state: StateFlow<ChefProfileState> = _state.asStateFlow()

    fun loadChefs(latitude: Float = 0f, longitude: Float = 0f, radiusMiles: Int = 0) {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                println("Loading chefs with latitude: $latitude, longitude: $longitude, radiusMiles: $radiusMiles")
                val chefs = getChefsByLocationUseCase(latitude, longitude, radiusMiles)
//                val chefs = if (latitude != 0.0 && longitude != 0.0) {
//                    getChefsByLocationUseCase(latitude, longitude, radiusMiles)
//                } else {
//                    getChefsUseCase()
//                }
                println("Loaded chefs: ${chefs.size}")
                _state.value = ChefProfileState(chefs = chefs, isLoading = false)
            } catch (e: Exception) {
                _state.value = ChefProfileState(isLoading = false, error = e.message)
            }
        }
    }
} 
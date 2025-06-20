package org.localchefs.app.shared.presentation.home

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.rickclephas.kmp.observableviewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import org.localchefs.app.shared.domain.location.GeocoderWrapper

class HomeViewModel : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    @NativeCoroutines
    val stateFlow: StateFlow<HomeState> = _state.asStateFlow()

    fun updateZipCode(zipCode: String) {
        _state.update {
            it.copy(zipCode = zipCode.take(5), error = null)
        }
    }

    fun updateSelectedDistance(distance: Int) {
        _state.update { it.copy(selectedDistance = distance) }
    }

    fun setLoading(loading: Boolean) {
        _state.update { it.copy(isLoading = loading) }
    }

    fun setError(error: String?) {
        _state.update { it.copy(error = error) }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }

    fun toggleDistanceMenu() {
        _state.update { it.copy(isDistanceMenuExpanded = !it.isDistanceMenuExpanded) }
    }

    fun setDistance(distance: Int) {
        _state.update {
            it.copy(selectedDistance = distance, isDistanceMenuExpanded = false)
        }
    }


    fun updateLocation(latitude: Float, longitude: Float) {
        _state.update { it.copy(latitude = latitude, longitude = longitude) }
    }

    fun showRationaleDialog(show: Boolean) {
        _state.update { it.copy(showRationaleDialog = show) }
    }

    fun showSettingsDialog(show: Boolean) {
        _state.update { it.copy(showSettingsDialog = show) }
    }

    fun validateZipCode(zipCode: String): Boolean {
        return zipCode.length == 5 && zipCode.all { it.isDigit() }
    }

    fun isValidZipCode(): Boolean {
        return validateZipCode(_state.value.zipCode)
    }

    fun hasValidLocation(): Boolean {
        return _state.value.latitude != 0f && _state.value.longitude != 0f
    }

    fun triggerLocationSearch(onSearch: (Float, Float, Int) -> Unit) {
        val value = _state.value
        if (hasValidLocation()) {
            onSearch(value.latitude, value.longitude, value.selectedDistance)
        } else {
            setError("Invalid coordinates")
        }
    }

    suspend fun searchCoordinatesByZip(zip: String, geocoder: GeocoderWrapper): Boolean {
        if (!validateZipCode(zip)) {
            setError("Please enter a valid 5-digit ZIP Code")
            return false
        }

        setLoading(true)
        val result = withContext(Dispatchers.IO) {
            geocoder.getCoordinatesFromZip(zip)
        }
        setLoading(false)

        return if (result != null) {
            updateLocation(result.first, result.second)
            clearError()
            true
        } else {
            setError("No address found for the ZIP Code")
            false
        }
    }

    suspend fun findUserLocation(geocoder: GeocoderWrapper): Boolean {
        setLoading(true)
        val coordinates = withContext(Dispatchers.IO) {
            geocoder.getCoordinatesFromUserLocation()
        }
        setLoading(false)

        return if (coordinates != null) {
            updateLocation(coordinates.first, coordinates.second)
            val zipCode = withContext(Dispatchers.IO) {
                geocoder.getZipCodeFromCoordinates(coordinates.first.toDouble(), coordinates.second.toDouble())
            }
            if (zipCode != null) {
                updateZipCode(zipCode)
            } else {
                setError("Unable to retrieve ZIP Code from current location")
            }
            clearError()
            true
        } else {
            setError("Unable to retrieve current location")
            false
        }
    }

    fun resetState() {
        _state.value = HomeState()
    }
} 
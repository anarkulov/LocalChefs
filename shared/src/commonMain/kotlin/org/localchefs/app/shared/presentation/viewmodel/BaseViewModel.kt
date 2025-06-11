package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.rickclephas.kmp.observableviewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    
    @NativeCoroutines
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    protected fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }
} 
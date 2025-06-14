package org.localchefs.app.shared.presentation.viewmodel

import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.localchefs.app.shared.domain.usecase.review.GetReviewsUseCase
import org.localchefs.app.shared.presentation.state.ReviewState

class ReviewViewModel(
    private val getReviewsUseCase: GetReviewsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ReviewState())
    val state: StateFlow<ReviewState> = _state.asStateFlow()

    fun loadReviews() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val reviews = getReviewsUseCase()
                _state.value = ReviewState(reviews = reviews, isLoading = false)
            } catch (e: Exception) {
                _state.value = ReviewState(isLoading = false, error = e.message)
            }
        }
    }
} 
package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.State

data class StateState(
    val states: List<State> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
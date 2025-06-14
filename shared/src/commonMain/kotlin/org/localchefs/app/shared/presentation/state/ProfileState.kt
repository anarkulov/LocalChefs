package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.Profile

data class ProfileState(
    val profiles: List<Profile> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
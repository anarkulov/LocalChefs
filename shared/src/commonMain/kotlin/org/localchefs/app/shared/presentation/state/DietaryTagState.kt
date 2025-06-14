package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.DietaryTag

data class DietaryTagState(
    val dietaryTags: List<DietaryTag> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
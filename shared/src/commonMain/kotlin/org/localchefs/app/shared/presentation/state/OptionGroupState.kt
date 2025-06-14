package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.OptionGroup

data class OptionGroupState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val optionGroups: List<OptionGroup> = emptyList()
) 
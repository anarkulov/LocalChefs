package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.OptionChoice

data class OptionChoiceState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val optionChoices: List<OptionChoice> = emptyList()
) 
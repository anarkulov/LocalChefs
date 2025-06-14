package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.Protein

data class ProteinState(
    val proteins: List<Protein> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.Certification

data class CertificationState(
    val certifications: List<Certification> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
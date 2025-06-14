package org.localchefs.app.shared.presentation.state

import org.localchefs.app.shared.domain.model.CertificationType

data class CertificationTypeState(
    val certificationTypes: List<CertificationType> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
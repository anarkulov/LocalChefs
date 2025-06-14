package org.localchefs.app.shared.domain.usecase.certification

import org.localchefs.app.shared.domain.model.CertificationType
import org.localchefs.app.shared.domain.repository.CertificationTypeRepository

class GetCertificationTypeBySlugUseCase(private val repository: CertificationTypeRepository) {
    suspend operator fun invoke(slug: String): CertificationType? = repository.getBySlug(slug)
} 
package org.localchefs.app.shared.domain.usecase.certification

import org.localchefs.app.shared.domain.model.CertificationType
import org.localchefs.app.shared.domain.repository.CertificationTypeRepository

class GetCertificationTypesUseCase(private val repository: CertificationTypeRepository) {
    suspend operator fun invoke(): List<CertificationType> = repository.getAll()
} 
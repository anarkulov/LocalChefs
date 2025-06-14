package org.localchefs.app.shared.domain.usecase.certification

import org.localchefs.app.shared.domain.model.Certification
import org.localchefs.app.shared.domain.repository.CertificationRepository

class GetCertificationsUseCase(private val repository: CertificationRepository) {
    suspend operator fun invoke(): List<Certification> = repository.getAll()
} 
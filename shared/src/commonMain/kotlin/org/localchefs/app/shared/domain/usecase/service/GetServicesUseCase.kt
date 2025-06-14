package org.localchefs.app.shared.domain.usecase.service

import org.localchefs.app.shared.domain.model.Service
import org.localchefs.app.shared.domain.repository.ServiceRepository

class GetServicesUseCase(private val repository: ServiceRepository) {
    suspend operator fun invoke(): List<Service> = repository.getAll()
} 
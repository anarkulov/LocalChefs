package org.localchefs.app.shared.domain.usecase.serviceCategory

import org.localchefs.app.shared.domain.model.ServiceCategory
import org.localchefs.app.shared.domain.repository.ServiceCategoryRepository

class GetServiceCategoriesUseCase(private val repository: ServiceCategoryRepository) {
    suspend operator fun invoke(): List<ServiceCategory> = repository.getAll()
} 
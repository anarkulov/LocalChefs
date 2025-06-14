package org.localchefs.app.shared.domain.usecase.option

import org.localchefs.app.shared.domain.model.OptionGroup
import org.localchefs.app.shared.domain.repository.OptionGroupRepository

class GetOptionGroupByIdUseCase(private val repository: OptionGroupRepository) {
    suspend operator fun invoke(id: String): OptionGroup? = repository.getById(id)
} 
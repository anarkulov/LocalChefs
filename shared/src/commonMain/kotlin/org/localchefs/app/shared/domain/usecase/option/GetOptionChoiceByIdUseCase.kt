package org.localchefs.app.shared.domain.usecase.option

import org.localchefs.app.shared.domain.model.OptionChoice
import org.localchefs.app.shared.domain.repository.OptionChoiceRepository

class GetOptionChoiceByIdUseCase(private val repository: OptionChoiceRepository) {
    suspend operator fun invoke(id: String): OptionChoice? = repository.getById(id)
} 
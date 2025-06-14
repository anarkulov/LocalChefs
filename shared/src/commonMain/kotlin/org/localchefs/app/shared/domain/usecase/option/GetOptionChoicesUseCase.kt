package org.localchefs.app.shared.domain.usecase.option

import org.localchefs.app.shared.domain.model.OptionChoice
import org.localchefs.app.shared.domain.repository.OptionChoiceRepository

class GetOptionChoicesUseCase(private val repository: OptionChoiceRepository) {
    suspend operator fun invoke(): List<OptionChoice> = repository.getAll()
} 
package org.localchefs.app.shared.domain.usecase.state

import org.localchefs.app.shared.domain.model.State
import org.localchefs.app.shared.domain.repository.StateRepository

class GetStatesUseCase(private val repository: StateRepository) {
    suspend operator fun invoke(): List<State> = repository.getAll()
} 
package org.localchefs.app.shared.domain.usecase.option

import org.localchefs.app.shared.domain.model.OptionGroup
import org.localchefs.app.shared.domain.repository.OptionGroupRepository

class GetOptionGroupsByDishIdUseCase(private val repository: OptionGroupRepository) {
    suspend operator fun invoke(dishId: String): List<OptionGroup> = repository.getByDishId(dishId)
} 
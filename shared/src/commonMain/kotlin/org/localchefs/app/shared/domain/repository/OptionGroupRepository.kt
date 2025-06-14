package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.OptionGroup

interface OptionGroupRepository {
    suspend fun getAll(): List<OptionGroup>
    suspend fun getById(id: String): OptionGroup?
    suspend fun getByDishId(dishId: String): List<OptionGroup>
    suspend fun insert(optionGroup: OptionGroup): OptionGroup?
    suspend fun update(id: String, optionGroup: OptionGroup): OptionGroup?
    suspend fun delete(id: String)
} 
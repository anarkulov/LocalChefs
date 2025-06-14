package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.OptionGroupApi
import org.localchefs.app.shared.domain.model.OptionGroup
import org.localchefs.app.shared.domain.repository.OptionGroupRepository

class OptionGroupRepositoryImpl(private val api: OptionGroupApi) : OptionGroupRepository {
    override suspend fun getAll(): List<OptionGroup> = api.getAll()
    override suspend fun getById(id: String): OptionGroup? = api.getById(id)
    override suspend fun getByDishId(dishId: String): List<OptionGroup> = api.getByDishId(dishId)
    override suspend fun insert(optionGroup: OptionGroup): OptionGroup? = api.insert(optionGroup)
    override suspend fun update(id: String, optionGroup: OptionGroup): OptionGroup? = api.update(id, optionGroup)
    override suspend fun delete(id: String) = api.delete(id)
} 
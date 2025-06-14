package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.OptionChoiceApi
import org.localchefs.app.shared.domain.model.OptionChoice
import org.localchefs.app.shared.domain.repository.OptionChoiceRepository

class OptionChoiceRepositoryImpl(private val api: OptionChoiceApi) : OptionChoiceRepository {
    override suspend fun getAll(): List<OptionChoice> = api.getAll()
    override suspend fun getById(id: String): OptionChoice? = api.getById(id)
    override suspend fun getByGroupId(groupId: String): List<OptionChoice> = api.getByGroupId(groupId)
    override suspend fun insert(optionChoice: OptionChoice): OptionChoice? = api.insert(optionChoice)
    override suspend fun update(id: String, optionChoice: OptionChoice): OptionChoice? = api.update(id, optionChoice)
    override suspend fun delete(id: String) = api.delete(id)
} 
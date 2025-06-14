package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.OptionChoice

interface OptionChoiceRepository {
    suspend fun getAll(): List<OptionChoice>
    suspend fun getById(id: String): OptionChoice?
    suspend fun getByGroupId(groupId: String): List<OptionChoice>
    suspend fun insert(optionChoice: OptionChoice): OptionChoice?
    suspend fun update(id: String, optionChoice: OptionChoice): OptionChoice?
    suspend fun delete(id: String)
} 
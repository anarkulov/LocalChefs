package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.StateApi
import org.localchefs.app.shared.domain.model.State
import org.localchefs.app.shared.domain.repository.StateRepository

class StateRepositoryImpl(private val api: StateApi) : StateRepository {
    override suspend fun getAll(): List<State> = api.getAll()
    override suspend fun getById(id: String): State? = api.getById(id)
    override suspend fun insert(state: State): State? = api.insert(state)
    override suspend fun update(id: String, state: State): State? = api.update(id, state)
    override suspend fun delete(id: String) = api.delete(id)
} 
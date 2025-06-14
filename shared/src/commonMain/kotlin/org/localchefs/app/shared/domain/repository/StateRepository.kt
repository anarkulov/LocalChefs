package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.State

interface StateRepository {
    suspend fun getAll(): List<State>
    suspend fun getById(id: String): State?
    suspend fun insert(state: State): State?
    suspend fun update(id: String, state: State): State?
    suspend fun delete(id: String)
} 
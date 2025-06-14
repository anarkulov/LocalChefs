package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.StateDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.State

class StateApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<State> {
        val result = supabaseClient.from("states").select().decodeList<StateDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): State? {
        val result = supabaseClient.from("states").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<StateDto>()
        return result?.toDomain()
    }

    suspend fun insert(state: State): State? {
        val dto = state.toDto()
        val result = supabaseClient.from("states").insert(dto).decodeSingleOrNull<StateDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, state: State): State? {
        val result = supabaseClient.from("states").update(state.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<StateDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("states").delete {
            filter { eq("id", id) }
        }
    }
} 
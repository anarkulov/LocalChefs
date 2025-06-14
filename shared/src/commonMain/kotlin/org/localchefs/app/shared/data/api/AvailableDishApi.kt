package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.AvailableDishDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.AvailableDish

class AvailableDishApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<AvailableDish> {
        val result = supabaseClient.from("available_dishes").select().decodeList<AvailableDishDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): AvailableDish? {
        val result = supabaseClient.from("available_dishes").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<AvailableDishDto>()
        return result?.toDomain()
    }

    suspend fun insert(availableDish: AvailableDish): AvailableDish? {
        val dto = availableDish.toDto()
        val result = supabaseClient.from("available_dishes").insert(dto).decodeSingleOrNull<AvailableDishDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, availableDish: AvailableDish): AvailableDish? {
        val result = supabaseClient.from("available_dishes").update(availableDish.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<AvailableDishDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("available_dishes").delete {
            filter { eq("id", id) }
        }
    }
} 
package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.ChefProfileDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.ChefProfile

class ChefProfileApi(private val supabaseClient: SupabaseClient) {
    suspend fun getChefs(): List<ChefProfile> {
        val result = supabaseClient.from("chef_profiles").select().decodeList<ChefProfileDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getChefById(id: String): ChefProfile? {
        val result = supabaseClient.from("chef_profiles").select {
            filter {
                eq("id", id)
            }
        }.decodeSingleOrNull<ChefProfileDto>()
        return result?.toDomain()
    }

    suspend fun updateChefProfile(id: String, data: ChefProfile): ChefProfile? {
        val dto = data.toDto()
        val result = supabaseClient.from("chef_profiles").update(dto) {
            filter {
                eq("id", id)
            }
        }.decodeSingleOrNull<ChefProfileDto>()
        return result?.toDomain()
    }
} 
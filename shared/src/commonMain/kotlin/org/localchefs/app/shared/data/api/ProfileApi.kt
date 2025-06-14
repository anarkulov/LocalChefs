package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.ProfileDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.Profile

class ProfileApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<Profile> {
        val result = supabaseClient.from("profiles").select().decodeList<ProfileDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): Profile? {
        val result = supabaseClient.from("profiles").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<ProfileDto>()
        return result?.toDomain()
    }

    suspend fun insert(profile: Profile): Profile? {
        val dto = profile.toDto()
        val result = supabaseClient.from("profiles").insert(dto).decodeSingleOrNull<ProfileDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, profile: Profile): Profile? {
        val result = supabaseClient.from("profiles").update(profile.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<ProfileDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("profiles").delete {
            filter { eq("id", id) }
        }
    }
} 
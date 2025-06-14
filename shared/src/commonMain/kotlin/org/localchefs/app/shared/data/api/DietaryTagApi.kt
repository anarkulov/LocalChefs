package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.DietaryTagDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.DietaryTag

class DietaryTagApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<DietaryTag> {
        val result = supabaseClient.from("dietary_tags").select().decodeList<DietaryTagDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): DietaryTag? {
        val result = supabaseClient.from("dietary_tags").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<DietaryTagDto>()
        return result?.toDomain()
    }

    suspend fun insert(dietaryTag: DietaryTag): DietaryTag? {
        val dto = dietaryTag.toDto()
        val result = supabaseClient.from("dietary_tags").insert(dto).decodeSingleOrNull<DietaryTagDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, dietaryTag: DietaryTag): DietaryTag? {
        val result = supabaseClient.from("dietary_tags").update(dietaryTag.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<DietaryTagDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("dietary_tags").delete {
            filter { eq("id", id) }
        }
    }
} 
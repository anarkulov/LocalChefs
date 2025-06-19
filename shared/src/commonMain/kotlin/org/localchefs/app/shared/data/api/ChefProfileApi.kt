package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import org.localchefs.app.shared.data.dto.ChefProfileDto
import org.localchefs.app.shared.data.dto.SearchChefsByLocationDto
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

    suspend fun getChefsByLocation(
        latitude: Double,
        longitude: Double,
        radiusMiles: Int
    ): List<ChefProfile> {

        val dto = SearchChefsByLocationDto(
            latitude = latitude,
            longitude = longitude,
            radiusMiles = radiusMiles
        )

        val json = Json.encodeToJsonElement(SearchChefsByLocationDto.serializer(), dto) as JsonObject
        val result = supabaseClient.postgrest.rpc(
            "get_chefs_by_location",
            json,
        ){}.decodeList<ChefProfileDto>()

        return result.map { it.toDomain() }
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
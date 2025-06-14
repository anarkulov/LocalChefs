package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.OptionGroupDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.OptionGroup

class OptionGroupApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<OptionGroup> {
        val result = supabaseClient.from("option_groups").select().decodeList<OptionGroupDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): OptionGroup? {
        val result = supabaseClient.from("option_groups").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<OptionGroupDto>()
        return result?.toDomain()
    }

    suspend fun getByDishId(dishId: String): List<OptionGroup> {
        val result = supabaseClient.from("option_groups").select {
            filter { eq("dish_id", dishId) }
        }.decodeList<OptionGroupDto>()
        return result.map { it.toDomain() }
    }

    suspend fun insert(optionGroup: OptionGroup): OptionGroup? {
        val dto = optionGroup.toDto()
        val result = supabaseClient.from("option_groups").insert(dto).decodeSingleOrNull<OptionGroupDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, optionGroup: OptionGroup): OptionGroup? {
        val result = supabaseClient.from("option_groups").update(optionGroup.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<OptionGroupDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("option_groups").delete {
            filter { eq("id", id) }
        }
    }
} 
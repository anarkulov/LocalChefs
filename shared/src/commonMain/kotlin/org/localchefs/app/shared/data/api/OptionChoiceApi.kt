package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.OptionChoiceDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.OptionChoice

class OptionChoiceApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<OptionChoice> {
        val result = supabaseClient.from("option_choices").select().decodeList<OptionChoiceDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): OptionChoice? {
        val result = supabaseClient.from("option_choices").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<OptionChoiceDto>()
        return result?.toDomain()
    }

    suspend fun getByGroupId(groupId: String): List<OptionChoice> {
        val result = supabaseClient.from("option_choices").select {
            filter { eq("group_id", groupId) }
        }.decodeList<OptionChoiceDto>()
        return result.map { it.toDomain() }
    }

    suspend fun insert(optionChoice: OptionChoice): OptionChoice? {
        val dto = optionChoice.toDto()
        val result = supabaseClient.from("option_choices").insert(dto).decodeSingleOrNull<OptionChoiceDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, optionChoice: OptionChoice): OptionChoice? {
        val result = supabaseClient.from("option_choices").update(optionChoice.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<OptionChoiceDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("option_choices").delete {
            filter { eq("id", id) }
        }
    }
} 
package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.ProteinDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.Protein

class ProteinApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<Protein> {
        val result = supabaseClient.from("proteins").select().decodeList<ProteinDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): Protein? {
        val result = supabaseClient.from("proteins").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<ProteinDto>()
        return result?.toDomain()
    }

    suspend fun insert(protein: Protein): Protein? {
        val dto = protein.toDto()
        val result = supabaseClient.from("proteins").insert(dto).decodeSingleOrNull<ProteinDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, protein: Protein): Protein? {
        val result = supabaseClient.from("proteins").update(protein.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<ProteinDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("proteins").delete {
            filter { eq("id", id) }
        }
    }
} 
package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.CertificationDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.Certification

class CertificationApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<Certification> {
        val result = supabaseClient.from("certifications").select().decodeList<CertificationDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): Certification? {
        val result = supabaseClient.from("certifications").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<CertificationDto>()
        return result?.toDomain()
    }

    suspend fun insert(certification: Certification): Certification? {
        val dto = certification.toDto()
        val result = supabaseClient.from("certifications").insert(dto).decodeSingleOrNull<CertificationDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, certification: Certification): Certification? {
        val result = supabaseClient.from("certifications").update(certification.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<CertificationDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("certifications").delete {
            filter { eq("id", id) }
        }
    }
} 
package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.CertificationTypeDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.CertificationType

class CertificationTypeApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<CertificationType> {
        val result = supabaseClient.from("certification_type").select().decodeList<CertificationTypeDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getBySlug(slug: String): CertificationType? {
        val result = supabaseClient.from("certification_type").select {
            filter { eq("slug", slug) }
        }.decodeSingleOrNull<CertificationTypeDto>()
        return result?.toDomain()
    }

    suspend fun insert(certType: CertificationType): CertificationType? {
        val dto = certType.toDto()
        val result = supabaseClient.from("certification_type").insert(dto).decodeSingleOrNull<CertificationTypeDto>()
        return result?.toDomain()
    }

    suspend fun update(slug: String, certType: CertificationType): CertificationType? {
        val result = supabaseClient.from("certification_type").update(certType.toDto()) {
            filter { eq("slug", slug) }
        }.decodeSingleOrNull<CertificationTypeDto>()
        return result?.toDomain()
    }

    suspend fun delete(slug: String) {
        supabaseClient.from("certification_type").delete {
            filter { eq("slug", slug) }
        }
    }
} 
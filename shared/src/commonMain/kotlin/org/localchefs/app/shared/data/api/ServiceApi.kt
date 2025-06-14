package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.ServiceDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.Service

class ServiceApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<Service> {
        val result = supabaseClient.from("services").select().decodeList<ServiceDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): Service? {
        val result = supabaseClient.from("services").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<ServiceDto>()
        return result?.toDomain()
    }

    suspend fun insert(service: Service): Service? {
        val dto = service.toDto()
        val result = supabaseClient.from("services").insert(dto).decodeSingleOrNull<ServiceDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, service: Service): Service? {
        val result = supabaseClient.from("services").update(service.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<ServiceDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("services").delete {
            filter { eq("id", id) }
        }
    }
} 
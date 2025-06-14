package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.ServiceCategoryDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.ServiceCategory

class ServiceCategoryApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<ServiceCategory> {
        val result = supabaseClient.from("service_categories").select().decodeList<ServiceCategoryDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getBySlug(slug: String): ServiceCategory? {
        val result = supabaseClient.from("service_categories").select {
            filter { eq("slug", slug) }
        }.decodeSingleOrNull<ServiceCategoryDto>()
        return result?.toDomain()
    }

    suspend fun insert(category: ServiceCategory): ServiceCategory? {
        val dto = category.toDto()
        val result = supabaseClient.from("service_categories").insert(dto).decodeSingleOrNull<ServiceCategoryDto>()
        return result?.toDomain()
    }

    suspend fun update(slug: String, category: ServiceCategory): ServiceCategory? {
        val result = supabaseClient.from("service_categories").update(category.toDto()) {
            filter { eq("slug", slug) }
        }.decodeSingleOrNull<ServiceCategoryDto>()
        return result?.toDomain()
    }

    suspend fun delete(slug: String) {
        supabaseClient.from("service_categories").delete {
            filter { eq("slug", slug) }
        }
    }
} 
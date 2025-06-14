package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.DeliveryTimeWindowDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.DeliveryTimeWindow

class DeliveryTimeWindowApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<DeliveryTimeWindow> {
        val result = supabaseClient.from("delivery_time_windows").select().decodeList<DeliveryTimeWindowDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): DeliveryTimeWindow? {
        val result = supabaseClient.from("delivery_time_windows").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<DeliveryTimeWindowDto>()
        return result?.toDomain()
    }

    suspend fun getByChefId(chefId: String): List<DeliveryTimeWindow> {
        val result = supabaseClient.from("delivery_time_windows").select {
            filter { eq("chef_id", chefId) }
        }.decodeList<DeliveryTimeWindowDto>()
        return result.map { it.toDomain() }
    }

    suspend fun insert(window: DeliveryTimeWindow): DeliveryTimeWindow? {
        val dto = window.toDto()
        val result = supabaseClient.from("delivery_time_windows").insert(dto).decodeSingleOrNull<DeliveryTimeWindowDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, window: DeliveryTimeWindow): DeliveryTimeWindow? {
        val result = supabaseClient.from("delivery_time_windows").update(window.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<DeliveryTimeWindowDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("delivery_time_windows").delete {
            filter { eq("id", id) }
        }
    }
} 
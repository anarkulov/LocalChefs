package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.ChefServiceBookingDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.ChefServiceBooking

class ChefServiceBookingApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<ChefServiceBooking> {
        val result = supabaseClient.from("chef_service_bookings").select().decodeList<ChefServiceBookingDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): ChefServiceBooking? {
        val result = supabaseClient.from("chef_service_bookings").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<ChefServiceBookingDto>()
        return result?.toDomain()
    }

    suspend fun insert(booking: ChefServiceBooking): ChefServiceBooking? {
        val dto = booking.toDto()
        val result = supabaseClient.from("chef_service_bookings").insert(dto).decodeSingleOrNull<ChefServiceBookingDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, booking: ChefServiceBooking): ChefServiceBooking? {
        val result = supabaseClient.from("chef_service_bookings").update(booking.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<ChefServiceBookingDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("chef_service_bookings").delete {
            filter { eq("id", id) }
        }
    }
} 
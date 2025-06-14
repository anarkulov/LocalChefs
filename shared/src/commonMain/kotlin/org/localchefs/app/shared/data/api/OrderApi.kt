package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.OrderDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.Order

class OrderApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<Order> {
        val result = supabaseClient.from("orders").select().decodeList<OrderDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): Order? {
        val result = supabaseClient.from("orders").select {
            filter {
                eq("id", id)
            }
        }.decodeSingleOrNull<OrderDto>()
        return result?.toDomain()
    }

    suspend fun insert(order: Order): Order? {
        val orderDto = order.toDto()
        val result = supabaseClient.from("orders").insert(orderDto).decodeSingleOrNull<OrderDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, order: Order): Order? {
        val result = supabaseClient.from("orders").update(order) {
            filter {
                eq("id", id)
            }
        }.decodeSingleOrNull<OrderDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("orders").delete {
            filter {
                eq("id", id)
            }
        }
    }
} 
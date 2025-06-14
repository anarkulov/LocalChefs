package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.DishDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.Dish

class DishApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<Dish> {
        val result = supabaseClient.from("dishes").select().decodeList<DishDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): Dish? {
        val result = supabaseClient.from("dishes").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<DishDto>()
        return result?.toDomain()
    }

    suspend fun insert(dish: Dish): Dish? {
        val dishDto = dish.toDto()
        val result = supabaseClient.from("dishes").insert(dishDto).decodeSingleOrNull<DishDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, dish: Dish): Dish? {
        val result = supabaseClient.from("dishes").update(dish.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<DishDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("dishes").delete {
            filter { eq("id", id) }
        }
    }
} 
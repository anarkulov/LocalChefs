package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.DishCategoryDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.DishCategory

class DishCategoryApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<DishCategory> {
        val result = supabaseClient.from("dish_category").select().decodeList<DishCategoryDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: Int): DishCategory? {
        val result = supabaseClient.from("dish_category").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<DishCategoryDto>()
        return result?.toDomain()
    }

    suspend fun insert(category: DishCategory): DishCategory? {
        val dto = category.toDto()
        val result = supabaseClient.from("dish_category").insert(dto).decodeSingleOrNull<DishCategoryDto>()
        return result?.toDomain()
    }

    suspend fun update(id: Int, category: DishCategory): DishCategory? {
        val result = supabaseClient.from("dish_category").update(category.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<DishCategoryDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: Int) {
        supabaseClient.from("dish_category").delete {
            filter { eq("id", id) }
        }
    }
} 
package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.FoodAllergenDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.FoodAllergen

class FoodAllergenApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<FoodAllergen> {
        val result = supabaseClient.from("food_allergens").select().decodeList<FoodAllergenDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): FoodAllergen? {
        val result = supabaseClient.from("food_allergens").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<FoodAllergenDto>()
        return result?.toDomain()
    }

    suspend fun insert(foodAllergen: FoodAllergen): FoodAllergen? {
        val dto = foodAllergen.toDto()
        val result = supabaseClient.from("food_allergens").insert(dto).decodeSingleOrNull<FoodAllergenDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, foodAllergen: FoodAllergen): FoodAllergen? {
        val result = supabaseClient.from("food_allergens").update(foodAllergen.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<FoodAllergenDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("food_allergens").delete {
            filter { eq("id", id) }
        }
    }
} 
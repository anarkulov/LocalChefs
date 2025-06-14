package org.localchefs.app.shared.data.api

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.localchefs.app.shared.data.dto.ReviewDto
import org.localchefs.app.shared.data.mapper.toDomain
import org.localchefs.app.shared.data.mapper.toDto
import org.localchefs.app.shared.domain.model.Review

class ReviewApi(private val supabaseClient: SupabaseClient) {
    suspend fun getAll(): List<Review> {
        val result = supabaseClient.from("reviews").select().decodeList<ReviewDto>()
        return result.map { it.toDomain() }
    }

    suspend fun getById(id: String): Review? {
        val result = supabaseClient.from("reviews").select {
            filter { eq("id", id) }
        }.decodeSingleOrNull<ReviewDto>()
        return result?.toDomain()
    }

    suspend fun insert(review: Review): Review? {
        val dto = review.toDto()
        val result = supabaseClient.from("reviews").insert(dto).decodeSingleOrNull<ReviewDto>()
        return result?.toDomain()
    }

    suspend fun update(id: String, review: Review): Review? {
        val result = supabaseClient.from("reviews").update(review.toDto()) {
            filter { eq("id", id) }
        }.decodeSingleOrNull<ReviewDto>()
        return result?.toDomain()
    }

    suspend fun delete(id: String) {
        supabaseClient.from("reviews").delete {
            filter { eq("id", id) }
        }
    }
} 
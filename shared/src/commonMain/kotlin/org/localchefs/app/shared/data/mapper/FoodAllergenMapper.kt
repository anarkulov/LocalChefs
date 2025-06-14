package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.FoodAllergenDto
import org.localchefs.app.shared.domain.model.FoodAllergen

fun FoodAllergenDto.toDomain(): FoodAllergen = FoodAllergen(
    allergenName = allergen_name,
    createdAt = created_at,
    description = description,
    examples = examples,
    id = id,
    updatedAt = updated_at
)

fun FoodAllergen.toDto(): FoodAllergenDto = FoodAllergenDto(
    allergen_name = allergenName,
    created_at = createdAt,
    description = description,
    examples = examples,
    id = id,
    updated_at = updatedAt
) 
package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.DishCategoryDto
import org.localchefs.app.shared.domain.model.DishCategory

fun DishCategoryDto.toDomain(): DishCategory = DishCategory(
    description = description,
    id = id,
    name = name,
    slug = slug
)

fun DishCategory.toDto(): DishCategoryDto = DishCategoryDto(
    description = description,
    id = id,
    name = name,
    slug = slug
) 
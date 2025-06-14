package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.OptionGroupDto
import org.localchefs.app.shared.domain.model.OptionGroup

fun OptionGroupDto.toDomain(): OptionGroup = OptionGroup(
    id = id,
    dishId = dish_id,
    name = name,
    minSelections = min_selections,
    maxSelections = max_selections,
    createdAt = created_at,
    updatedAt = updated_at
)

fun OptionGroup.toDto(): OptionGroupDto = OptionGroupDto(
    id = id,
    dish_id = dishId,
    name = name,
    min_selections = minSelections,
    max_selections = maxSelections,
    created_at = createdAt,
    updated_at = updatedAt
) 
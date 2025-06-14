package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.DietaryTagDto
import org.localchefs.app.shared.domain.model.DietaryTag

fun DietaryTagDto.toDomain(): DietaryTag = DietaryTag(
    id = id,
    tagName = tag_name,
    displayName = display_name,
    description = description,
    shortcode = shortcode,
    createdAt = created_at,
    updatedAt = updated_at
)

fun DietaryTag.toDto(): DietaryTagDto = DietaryTagDto(
    id = id,
    tag_name = tagName,
    display_name = displayName,
    description = description,
    shortcode = shortcode,
    created_at = createdAt,
    updated_at = updatedAt
) 
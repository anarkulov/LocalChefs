package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.ServiceCategoryDto
import org.localchefs.app.shared.domain.model.ServiceCategory

fun ServiceCategoryDto.toDomain(): ServiceCategory = ServiceCategory(
    displayName = display_name,
    slug = slug
)

fun ServiceCategory.toDto(): ServiceCategoryDto = ServiceCategoryDto(
    display_name = displayName,
    slug = slug
) 
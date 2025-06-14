package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.ServiceDto
import org.localchefs.app.shared.domain.model.Service

fun ServiceDto.toDomain(): Service = Service(
    id = id,
    chefId = chef_id,
    name = name,
    description = description,
    price = price,
    duration = duration,
    category = category,
    createdAt = created_at,
    updatedAt = updated_at
)

fun Service.toDto(): ServiceDto = ServiceDto(
    id = id,
    chef_id = chefId,
    name = name,
    description = description,
    price = price,
    duration = duration,
    category = category,
    created_at = createdAt,
    updated_at = updatedAt
) 
package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.DeliveryTimeWindowDto
import org.localchefs.app.shared.domain.model.DeliveryTimeWindow

fun DeliveryTimeWindowDto.toDomain(): DeliveryTimeWindow = DeliveryTimeWindow(
    chefId = chef_id,
    createdAt = created_at,
    endTime = end_time,
    id = id,
    startTime = start_time,
    updatedAt = updated_at
)

fun DeliveryTimeWindow.toDto(): DeliveryTimeWindowDto = DeliveryTimeWindowDto(
    chef_id = chefId,
    created_at = createdAt,
    end_time = endTime,
    id = id,
    start_time = startTime,
    updated_at = updatedAt
) 
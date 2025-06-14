package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.AvailableDishDto
import org.localchefs.app.shared.domain.model.AvailableDish

fun AvailableDishDto.toDomain(): AvailableDish = AvailableDish(
    id = id,
    availableDate = available_date,
    chefId = chef_id,
    createdAt = created_at,
    dishId = dish_id,
    notes = notes,
    quantityAvailable = quantity_available
)

fun AvailableDish.toDto(): AvailableDishDto = AvailableDishDto(
    id = id,
    available_date = availableDate,
    chef_id = chefId,
    created_at = createdAt,
    dish_id = dishId,
    notes = notes,
    quantity_available = quantityAvailable
) 
package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.OptionChoiceDto
import org.localchefs.app.shared.domain.model.OptionChoice

fun OptionChoiceDto.toDomain(): OptionChoice = OptionChoice(
    id = id,
    groupId = group_id,
    name = name,
    additionalPrice = additional_price,
    createdAt = created_at,
    updatedAt = updated_at
)

fun OptionChoice.toDto(): OptionChoiceDto = OptionChoiceDto(
    id = id,
    group_id = groupId,
    name = name,
    additional_price = additionalPrice,
    created_at = createdAt,
    updated_at = updatedAt
) 
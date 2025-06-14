package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.StateDto
import org.localchefs.app.shared.domain.model.State

fun StateDto.toDomain(): State = State(
    id = id,
    name = name,
    abbreviation = abbreviation
)

fun State.toDto(): StateDto = StateDto(
    id = id,
    name = name,
    abbreviation = abbreviation
) 
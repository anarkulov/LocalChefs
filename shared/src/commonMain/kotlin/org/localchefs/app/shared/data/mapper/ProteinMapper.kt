package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.ProteinDto
import org.localchefs.app.shared.domain.model.Protein

fun ProteinDto.toDomain(): Protein = Protein(
    id = id,
    name = name,
    createdAt = created_at,
    updatedAt = updated_at
)

fun Protein.toDto(): ProteinDto = ProteinDto(
    id = id,
    name = name,
    created_at = createdAt,
    updated_at = updatedAt
) 
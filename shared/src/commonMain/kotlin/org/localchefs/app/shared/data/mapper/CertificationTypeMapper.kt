package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.CertificationTypeDto
import org.localchefs.app.shared.domain.model.CertificationType

fun CertificationTypeDto.toDomain(): CertificationType = CertificationType(
    description = description,
    name = name,
    required = required,
    slug = slug
)

fun CertificationType.toDto(): CertificationTypeDto = CertificationTypeDto(
    description = description,
    name = name,
    required = required,
    slug = slug
) 
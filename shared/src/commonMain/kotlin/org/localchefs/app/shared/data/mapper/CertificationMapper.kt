package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.CertificationDto
import org.localchefs.app.shared.domain.model.Certification

fun CertificationDto.toDomain(): Certification = Certification(
    certificateNumber = certificate_number,
    chefId = chef_id,
    createdAt = created_at,
    documentUrl = document_url,
    expiresAt = expires_at,
    id = id,
    issuedAt = issued_at,
    type = type,
    updatedAt = updated_at,
    verified = verified
)

fun Certification.toDto(): CertificationDto = CertificationDto(
    certificate_number = certificateNumber,
    chef_id = chefId,
    created_at = createdAt,
    document_url = documentUrl,
    expires_at = expiresAt,
    id = id,
    issued_at = issuedAt,
    type = type,
    updated_at = updatedAt,
    verified = verified
) 
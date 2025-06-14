package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.CertificationType

interface CertificationTypeRepository {
    suspend fun getAll(): List<CertificationType>
    suspend fun getBySlug(slug: String): CertificationType?
    suspend fun insert(certType: CertificationType): CertificationType?
    suspend fun update(slug: String, certType: CertificationType): CertificationType?
    suspend fun delete(slug: String)
} 
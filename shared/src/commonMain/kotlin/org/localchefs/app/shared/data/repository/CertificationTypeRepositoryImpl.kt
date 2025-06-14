package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.CertificationTypeApi
import org.localchefs.app.shared.domain.model.CertificationType
import org.localchefs.app.shared.domain.repository.CertificationTypeRepository

class CertificationTypeRepositoryImpl(private val api: CertificationTypeApi) : CertificationTypeRepository {
    override suspend fun getAll(): List<CertificationType> = api.getAll()
    override suspend fun getBySlug(slug: String): CertificationType? = api.getBySlug(slug)
    override suspend fun insert(certType: CertificationType): CertificationType? = api.insert(certType)
    override suspend fun update(slug: String, certType: CertificationType): CertificationType? = api.update(slug, certType)
    override suspend fun delete(slug: String) = api.delete(slug)
} 
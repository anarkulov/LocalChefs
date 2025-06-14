package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.CertificationApi
import org.localchefs.app.shared.domain.model.Certification
import org.localchefs.app.shared.domain.repository.CertificationRepository

class CertificationRepositoryImpl(private val api: CertificationApi) : CertificationRepository {
    override suspend fun getAll(): List<Certification> = api.getAll()
    override suspend fun getById(id: String): Certification? = api.getById(id)
    override suspend fun insert(certification: Certification): Certification? = api.insert(certification)
    override suspend fun update(id: String, certification: Certification): Certification? = api.update(id, certification)
    override suspend fun delete(id: String) = api.delete(id)
} 
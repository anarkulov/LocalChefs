package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.Certification

interface CertificationRepository {
    suspend fun getAll(): List<Certification>
    suspend fun getById(id: String): Certification?
    suspend fun insert(certification: Certification): Certification?
    suspend fun update(id: String, certification: Certification): Certification?
    suspend fun delete(id: String)
} 
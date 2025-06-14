package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.ProteinApi
import org.localchefs.app.shared.domain.model.Protein
import org.localchefs.app.shared.domain.repository.ProteinRepository

class ProteinRepositoryImpl(private val api: ProteinApi) : ProteinRepository {
    override suspend fun getAll(): List<Protein> = api.getAll()
    override suspend fun getById(id: String): Protein? = api.getById(id)
    override suspend fun insert(protein: Protein): Protein? = api.insert(protein)
    override suspend fun update(id: String, protein: Protein): Protein? = api.update(id, protein)
    override suspend fun delete(id: String) = api.delete(id)
} 
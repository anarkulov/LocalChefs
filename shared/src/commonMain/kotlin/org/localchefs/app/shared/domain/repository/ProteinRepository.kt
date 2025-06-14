package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.Protein

interface ProteinRepository {
    suspend fun getAll(): List<Protein>
    suspend fun getById(id: String): Protein?
    suspend fun insert(protein: Protein): Protein?
    suspend fun update(id: String, protein: Protein): Protein?
    suspend fun delete(id: String)
} 
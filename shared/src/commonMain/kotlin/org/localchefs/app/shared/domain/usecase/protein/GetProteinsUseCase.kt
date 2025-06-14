package org.localchefs.app.shared.domain.usecase.protein

import org.localchefs.app.shared.domain.model.Protein
import org.localchefs.app.shared.domain.repository.ProteinRepository

class GetProteinsUseCase(private val repository: ProteinRepository) {
    suspend operator fun invoke(): List<Protein> = repository.getAll()
} 
package org.localchefs.app.shared.domain.usecase.profile

import org.localchefs.app.shared.domain.model.Profile
import org.localchefs.app.shared.domain.repository.ProfileRepository

class GetProfilesUseCase(private val repository: ProfileRepository) {
    suspend operator fun invoke(): List<Profile> = repository.getAll()
} 
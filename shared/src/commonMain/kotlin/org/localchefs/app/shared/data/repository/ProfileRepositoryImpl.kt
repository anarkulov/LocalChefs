package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.ProfileApi
import org.localchefs.app.shared.domain.model.Profile
import org.localchefs.app.shared.domain.repository.ProfileRepository

class ProfileRepositoryImpl(private val api: ProfileApi) : ProfileRepository {
    override suspend fun getAll(): List<Profile> = api.getAll()
    override suspend fun getById(id: String): Profile? = api.getById(id)
    override suspend fun insert(profile: Profile): Profile? = api.insert(profile)
    override suspend fun update(id: String, profile: Profile): Profile? = api.update(id, profile)
    override suspend fun delete(id: String) = api.delete(id)
} 
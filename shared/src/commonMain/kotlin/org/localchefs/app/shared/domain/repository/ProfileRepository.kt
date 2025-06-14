package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.Profile

interface ProfileRepository {
    suspend fun getAll(): List<Profile>
    suspend fun getById(id: String): Profile?
    suspend fun insert(profile: Profile): Profile?
    suspend fun update(id: String, profile: Profile): Profile?
    suspend fun delete(id: String)
} 
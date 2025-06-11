package org.localchefs.app.shared.data.remote.auth

import io.github.jan.supabase.auth.user.UserSession
import kotlinx.coroutines.flow.Flow

interface AuthManager {
    val currentSession: Flow<UserSession?>
    val isAuthenticated: Flow<Boolean>
    val userId: Flow<String?>
    
    suspend fun signIn(email: String, password: String)
    suspend fun signUp(email: String, password: String)
    suspend fun signOut()
    suspend fun resetPassword(email: String)
    suspend fun refreshSession(refreshToken: String)
} 
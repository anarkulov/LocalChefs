package org.localchefs.app.shared.data.remote.auth

import io.github.jan.supabase.auth.user.UserSession
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import org.localchefs.app.shared.data.remote.SupabaseClient

class AuthManagerImpl : AuthManager {
    override val currentSession: Flow<UserSession?> = flow {
        emit(SupabaseClient.client.auth.currentSessionOrNull())
    }

    override val isAuthenticated: Flow<Boolean> = currentSession.map { it != null }
    
    override val userId: Flow<String?> = currentSession.map { it?.user?.id }

    override suspend fun signIn(email: String, password: String) {
        SupabaseClient.client.auth.signInWith(Email) {
            this.email = email
            this.password = password
        }
    }

    override suspend fun signUp(email: String, password: String) {
        SupabaseClient.client.auth.signUpWith(Email) {
            this.email = email
            this.password = password
        }
    }

    override suspend fun signOut() {
        SupabaseClient.client.auth.signOut()
    }

    override suspend fun resetPassword(email: String) {
        SupabaseClient.client.auth.resetPasswordForEmail(email)
    }
    
    override suspend fun refreshSession(refreshToken: String) {
        SupabaseClient.client.auth.refreshSession(refreshToken = refreshToken)
    }
} 
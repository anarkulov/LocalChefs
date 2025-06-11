package org.localchefs.app.shared.di

import io.ktor.client.HttpClient
import org.koin.dsl.module
import org.localchefs.app.shared.network.HttpClientProvider
import org.localchefs.app.shared.data.remote.SupabaseClient
import org.localchefs.app.shared.data.remote.auth.AuthManager
import org.localchefs.app.shared.data.remote.auth.AuthManagerImpl

val networkModule = module {
    single { HttpClientProvider().create() }
    single { SupabaseClient.client }
}

val authModule = module {
    single<AuthManager> { AuthManagerImpl() }
}

val sharedModule = module {
    includes(networkModule, authModule)
} 
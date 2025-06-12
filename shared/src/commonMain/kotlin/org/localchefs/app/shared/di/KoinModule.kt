package org.localchefs.app.shared.di

import io.ktor.client.HttpClient
import org.koin.dsl.module
import org.localchefs.app.shared.network.HttpClientProvider
import org.localchefs.app.shared.data.remote.SupabaseClient
import org.localchefs.app.shared.data.remote.auth.AuthManager
import org.localchefs.app.shared.data.remote.auth.AuthManagerImpl
import org.localchefs.app.shared.data.api.ChefProfileApi
import org.localchefs.app.shared.domain.repository.ChefProfileRepository
import org.localchefs.app.shared.data.repository.ChefProfileRepositoryImpl
import org.localchefs.app.shared.domain.usecase.GetChefsUseCase
import org.localchefs.app.shared.presentation.viewmodel.ChefProfileViewModel

val networkModule = module {
    single { HttpClientProvider().create() }
    single { SupabaseClient.client }
}

val authModule = module {
    single<AuthManager> { AuthManagerImpl() }
}

val chefProfileModule = module {
    single { ChefProfileApi(get()) }
    single<ChefProfileRepository> { ChefProfileRepositoryImpl(get()) }
    single { GetChefsUseCase(get()) }
    single { ChefProfileViewModel(get()) }
}

val sharedModule = module {
    includes(networkModule, authModule, chefProfileModule)
} 
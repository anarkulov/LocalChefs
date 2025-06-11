package org.localchefs.app.shared.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import org.localchefs.app.shared.network.HttpClientProvider

val networkModule = module {
    single { HttpClientProvider().create() }
}

val sharedModule = module {
    includes(networkModule)
    single {
        val json = Json { ignoreUnknownKeys = true }
        HttpClient {
            install(ContentNegotiation) {
                json(json, contentType = ContentType.Any)
            }
        }
    }
} 
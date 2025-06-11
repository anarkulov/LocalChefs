package org.localchefs.app.shared.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

expect class HttpClientProvider() {
    fun create(): HttpClient
}

internal fun createHttpClient(json: Json): HttpClient {
    return HttpClient {
        install(ContentNegotiation) {
            json(json, contentType = io.ktor.http.ContentType.Any)
        }
    }
} 
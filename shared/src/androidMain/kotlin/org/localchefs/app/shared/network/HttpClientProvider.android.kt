package org.localchefs.app.shared.network

import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json

actual class HttpClientProvider {
    actual fun create(): HttpClient {
        val json = Json { ignoreUnknownKeys = true }
        return createHttpClient(json)
    }
} 
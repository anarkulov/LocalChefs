package org.localchefs.app.shared.domain.location

interface GeocoderWrapper {
    suspend fun getCoordinatesFromZip(zip: String): Pair<Float, Float>?
    suspend fun getCoordinatesFromUserLocation(): Pair<Float, Float>?
    suspend fun getZipCodeFromCoordinates(latitude: Double, longitude: Double): String?
}
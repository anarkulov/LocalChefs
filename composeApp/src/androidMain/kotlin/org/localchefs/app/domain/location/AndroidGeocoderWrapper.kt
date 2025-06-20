package org.localchefs.app.domain.location

import android.annotation.SuppressLint
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.os.Build
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.suspendCancellableCoroutine
import org.localchefs.app.shared.domain.location.GeocoderWrapper
import kotlin.coroutines.resumeWithException

class AndroidGeocoderWrapper(private val context: Context) : GeocoderWrapper {
    override suspend fun getCoordinatesFromZip(zip: String): Pair<Float, Float>? =
        withContext(Dispatchers.IO) {
            val geocoder = Geocoder(context)
            val result = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                suspendCancellableCoroutine { cont ->
                    geocoder.getFromLocationName(zip, 1) { addresses ->
                        cont.resume(addresses.firstOrNull()) { cause, _, _ -> null?.let { it(cause) } }
                    }
                }
            } else {
                geocoder.getFromLocationName(zip, 1)?.firstOrNull()
            }
            result?.let { it.latitude.toFloat() to it.longitude.toFloat() }
        }

    @SuppressLint("MissingPermission")
    override suspend fun getCoordinatesFromUserLocation(): Pair<Float, Float>? = suspendCancellableCoroutine { cont ->
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    cont.resume(location.latitude.toFloat() to location.longitude.toFloat(), null)
                } else {
                    cont.resume(null, null)
                }
            }
            .addOnFailureListener {
                cont.resume(null, null)
            }
    }

    override suspend fun getZipCodeFromCoordinates(latitude: Double, longitude: Double): String? = withContext(Dispatchers.IO) {
        val geocoder = Geocoder(context)
        val addresses = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            suspendCancellableCoroutine<List<Address>> { cont ->
                geocoder.getFromLocation(latitude, longitude, 1) { results ->
                    cont.resume(results) { cause, _, _ ->
                        cont.resumeWithException(cause)
                    }
                }
            }
        } else {
            geocoder.getFromLocation(latitude, longitude, 1)
        }
        addresses?.firstOrNull()?.postalCode
    }
}

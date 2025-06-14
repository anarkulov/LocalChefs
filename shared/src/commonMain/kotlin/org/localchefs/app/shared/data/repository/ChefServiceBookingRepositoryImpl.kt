package org.localchefs.app.shared.data.repository

import org.localchefs.app.shared.data.api.ChefServiceBookingApi
import org.localchefs.app.shared.domain.model.ChefServiceBooking
import org.localchefs.app.shared.domain.repository.ChefServiceBookingRepository

class ChefServiceBookingRepositoryImpl(private val api: ChefServiceBookingApi) : ChefServiceBookingRepository {
    override suspend fun getAll(): List<ChefServiceBooking> = api.getAll()
    override suspend fun getById(id: String): ChefServiceBooking? = api.getById(id)
    override suspend fun insert(booking: ChefServiceBooking): ChefServiceBooking? = api.insert(booking)
    override suspend fun update(id: String, booking: ChefServiceBooking): ChefServiceBooking? = api.update(id, booking)
    override suspend fun delete(id: String) = api.delete(id)
} 
package org.localchefs.app.shared.domain.repository

import org.localchefs.app.shared.domain.model.ChefServiceBooking

interface ChefServiceBookingRepository {
    suspend fun getAll(): List<ChefServiceBooking>
    suspend fun getById(id: String): ChefServiceBooking?
    suspend fun insert(booking: ChefServiceBooking): ChefServiceBooking?
    suspend fun update(id: String, booking: ChefServiceBooking): ChefServiceBooking?
    suspend fun delete(id: String)
} 
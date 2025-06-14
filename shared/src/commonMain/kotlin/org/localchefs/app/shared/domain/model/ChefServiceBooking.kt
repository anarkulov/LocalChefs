package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ChefServiceBooking(
    val id: String,
    val address: String? = null,
    val agreedToDepositTerms: Boolean,
    val bookingDate: String,
    val bookingTime: String,
    val chefId: String,
    val clientId: String,
    val createdAt: String,
    val customRequests: String? = null,
    val depositAmount: Double? = null,
    val dietaryRestrictions: String? = null,
    val email: String,
    val eventType: String? = null,
    val fullName: String,
    val instructions: String? = null,
    val numberOfGuests: Int,
    val phone: String,
    val serviceId: String,
    val status: String,
    val updatedAt: String,
    val zipcode: String
) 
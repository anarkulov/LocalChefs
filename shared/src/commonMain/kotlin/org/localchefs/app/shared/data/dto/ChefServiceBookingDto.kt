package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ChefServiceBookingDto(
    val id: String,
    val address: String? = null,
    val agreed_to_deposit_terms: Boolean,
    val booking_date: String,
    val booking_time: String,
    val chef_id: String,
    val client_id: String,
    val created_at: String,
    val custom_requests: String? = null,
    val deposit_amount: Double? = null,
    val dietary_restrictions: String? = null,
    val email: String,
    val event_type: String? = null,
    val full_name: String,
    val instructions: String? = null,
    val number_of_guests: Int,
    val phone: String,
    val service_id: String,
    val status: String,
    val updated_at: String,
    val zipcode: String
) 
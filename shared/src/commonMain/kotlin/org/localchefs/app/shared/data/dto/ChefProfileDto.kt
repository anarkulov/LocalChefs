package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ChefProfileDto(
    val id: String,
    val name: String? = null,
    val bio: String? = null,
    val address: String? = null,
    val city: String? = null,
    val state: String? = null,
    val zip_code: String,
    val bg_image: String? = null,
    val cuisines: List<String>? = null,
    val delivery_days: List<String>? = null,
    val delivery_fee: Double? = null,
    val delivery_radius_miles: Double? = null,
    val facebook: String? = null,
    val free_delivery_above: Double? = null,
    val instagram: String? = null,
    val is_active: Boolean? = null,
    val is_agreement_accepted: Boolean? = null,
    val is_delivery_available: Boolean? = null,
    val is_featured: Boolean? = null,
    val is_verified: Boolean? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val location: String? = null, // Use String for now
    val min_order_notice_hours: Int? = null,
    val minimum_order_amount: Double? = null,
    val rating: Double? = null,
    val review_count: Int? = null,
    val telegram: String? = null,
    val type: String? = null,
    val whatsapp: String? = null,
    val created_at: String,
    val updated_at: String
) 
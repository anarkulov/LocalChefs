package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ChefProfile(
    val id: String,
    val name: String?,
    val bio: String?,
    val address: String?,
    val city: String?,
    val state: String?,
    val zipCode: String,
    val bgImage: String?,
    val cuisines: List<String>?,
    val deliveryDays: List<String>?,
    val deliveryFee: Double?,
    val deliveryRadiusMiles: Double?,
    val facebook: String?,
    val freeDeliveryAbove: Double?,
    val instagram: String?,
    val isActive: Boolean?,
    val isAgreementAccepted: Boolean?,
    val isDeliveryAvailable: Boolean?,
    val isFeatured: Boolean?,
    val isVerified: Boolean?,
    val latitude: Double?,
    val longitude: Double?,
    val location: String?, // Use String for now
    val minOrderNoticeHours: Int?,
    val minimumOrderAmount: Double?,
    val rating: Double?,
    val reviewCount: Int?,
    val telegram: String?,
    val type: String?,
    val whatsapp: String?,
    val createdAt: String,
    val updatedAt: String
) 
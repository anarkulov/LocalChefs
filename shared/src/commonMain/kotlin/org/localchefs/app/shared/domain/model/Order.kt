package org.localchefs.app.shared.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val id: String,
    val buyerId: String,
    val chefId: String,
    val currency: String,
    val deliveryAddress: String? = null,
    val deliveryFee: Double? = null,
    val deliveryMethod: String,
    val notes: String? = null,
    val orderedAt: String,
    val paymentMethod: String,
    val scheduledFor: String? = null,
    val specialInstructions: String? = null,
    val status: String,
    val subtotal: Double,
    val tax: Double,
    val tip: Double? = null,
    val totalAmount: Double,
    val updatedAt: String
) 
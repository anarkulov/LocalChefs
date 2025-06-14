package org.localchefs.app.shared.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class OrderDto(
    val id: String,
    val buyer_id: String,
    val chef_id: String,
    val currency: String,
    val delivery_address: String? = null,
    val delivery_fee: Double? = null,
    val delivery_method: String,
    val notes: String? = null,
    val ordered_at: String,
    val payment_method: String,
    val scheduled_for: String? = null,
    val special_instructions: String? = null,
    val status: String,
    val subtotal: Double,
    val tax: Double,
    val tip: Double? = null,
    val total_amount: Double,
    val updated_at: String
) 
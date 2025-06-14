package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.OrderDto
import org.localchefs.app.shared.domain.model.Order

fun OrderDto.toDomain(): Order = Order(
    id = id,
    buyerId = buyer_id,
    chefId = chef_id,
    currency = currency,
    deliveryAddress = delivery_address,
    deliveryFee = delivery_fee,
    deliveryMethod = delivery_method,
    notes = notes,
    orderedAt = ordered_at,
    paymentMethod = payment_method,
    scheduledFor = scheduled_for,
    specialInstructions = special_instructions,
    status = status,
    subtotal = subtotal,
    tax = tax,
    tip = tip,
    totalAmount = total_amount,
    updatedAt = updated_at
)

fun Order.toDto(): OrderDto = OrderDto(
    id = id,
    buyer_id = buyerId,
    chef_id = chefId,
    currency = currency,
    delivery_address = deliveryAddress,
    delivery_fee = deliveryFee,
    delivery_method = deliveryMethod,
    notes = notes,
    ordered_at = orderedAt,
    payment_method = paymentMethod,
    scheduled_for = scheduledFor,
    special_instructions = specialInstructions,
    status = status,
    subtotal = subtotal,
    tax = tax,
    tip = tip,
    total_amount = totalAmount,
    updated_at = updatedAt
) 
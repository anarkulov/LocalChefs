package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.ChefServiceBookingDto
import org.localchefs.app.shared.domain.model.ChefServiceBooking

fun ChefServiceBookingDto.toDomain(): ChefServiceBooking = ChefServiceBooking(
    id = id,
    address = address,
    agreedToDepositTerms = agreed_to_deposit_terms,
    bookingDate = booking_date,
    bookingTime = booking_time,
    chefId = chef_id,
    clientId = client_id,
    createdAt = created_at,
    customRequests = custom_requests,
    depositAmount = deposit_amount,
    dietaryRestrictions = dietary_restrictions,
    email = email,
    eventType = event_type,
    fullName = full_name,
    instructions = instructions,
    numberOfGuests = number_of_guests,
    phone = phone,
    serviceId = service_id,
    status = status,
    updatedAt = updated_at,
    zipcode = zipcode
)

fun ChefServiceBooking.toDto(): ChefServiceBookingDto = ChefServiceBookingDto(
    id = id,
    address = address,
    agreed_to_deposit_terms = agreedToDepositTerms,
    booking_date = bookingDate,
    booking_time = bookingTime,
    chef_id = chefId,
    client_id = clientId,
    created_at = createdAt,
    custom_requests = customRequests,
    deposit_amount = depositAmount,
    dietary_restrictions = dietaryRestrictions,
    email = email,
    event_type = eventType,
    full_name = fullName,
    instructions = instructions,
    number_of_guests = numberOfGuests,
    phone = phone,
    service_id = serviceId,
    status = status,
    updated_at = updatedAt,
    zipcode = zipcode
) 
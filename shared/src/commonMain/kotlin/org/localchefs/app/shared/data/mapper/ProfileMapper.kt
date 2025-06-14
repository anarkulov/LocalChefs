package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.ProfileDto
import org.localchefs.app.shared.domain.model.Profile

fun ProfileDto.toDomain(): Profile = Profile(
    id = id,
    allergies = allergies,
    avatarUrl = avatar_url,
    city = city,
    createdAt = created_at,
    deactivatedAt = deactivated_at,
    deliveryAddress = delivery_address,
    email = email,
    isActive = is_active,
    location = location,
    name = name,
    notificationPreferences = notification_preferences,
    phone = phone,
    role = role,
    state = state,
    updatedAt = updated_at,
    zipCode = zip_code
)

fun Profile.toDto(): ProfileDto = ProfileDto(
    id = id,
    allergies = allergies,
    avatar_url = avatarUrl,
    city = city,
    created_at = createdAt,
    deactivated_at = deactivatedAt,
    delivery_address = deliveryAddress,
    email = email,
    is_active = isActive,
    location = location,
    name = name,
    notification_preferences = notificationPreferences,
    phone = phone,
    role = role,
    state = state,
    updated_at = updatedAt,
    zip_code = zipCode
) 
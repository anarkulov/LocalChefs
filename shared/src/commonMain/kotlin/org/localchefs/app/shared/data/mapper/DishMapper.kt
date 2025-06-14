package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.DishDto
import org.localchefs.app.shared.domain.model.Dish

fun DishDto.toDomain(): Dish = Dish(
    id = id,
    chefId = chef_id,
    createdAt = created_at,
    description = description,
    dietaryTags = dietary_tags,
    dishCategoryId = dish_category_id,
    imageUrl = image_url,
    isActive = is_active,
    minOrderAmount = min_order_amount,
    name = name,
    price = price,
    updatedAt = updated_at
)

fun Dish.toDto(): DishDto = DishDto(
    id = id,
    chef_id = chefId,
    created_at = createdAt,
    description = description,
    dietary_tags = dietaryTags,
    dish_category_id = dishCategoryId,
    image_url = imageUrl,
    is_active = isActive,
    min_order_amount = minOrderAmount,
    name = name,
    price = price,
    updated_at = updatedAt
) 
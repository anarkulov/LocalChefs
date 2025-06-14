package org.localchefs.app.shared.data.mapper

import org.localchefs.app.shared.data.dto.ReviewDto
import org.localchefs.app.shared.domain.model.Review

fun ReviewDto.toDomain(): Review = Review(
    id = id,
    chefId = chef_id,
    chefReply = chef_reply,
    chefReplyAt = chef_reply_at,
    comment = comment,
    createdAt = created_at,
    orderId = order_id,
    rating = rating,
    reviewerId = reviewer_id,
    tags = tags
)

fun Review.toDto(): ReviewDto = ReviewDto(
    id = id,
    chef_id = chefId,
    chef_reply = chefReply,
    chef_reply_at = chefReplyAt,
    comment = comment,
    created_at = createdAt,
    order_id = orderId,
    rating = rating,
    reviewer_id = reviewerId,
    tags = tags
) 
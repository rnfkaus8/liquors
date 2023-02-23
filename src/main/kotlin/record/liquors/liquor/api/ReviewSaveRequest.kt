package record.liquors.liquor.api

import record.liquors.liquor.entity.LiquorRating

data class ReviewSaveRequest(
    val content: String,

    val rating: LiquorRating,
)

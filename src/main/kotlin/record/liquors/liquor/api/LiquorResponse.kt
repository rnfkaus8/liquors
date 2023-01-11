package record.liquors.liquor.api

import record.liquors.liquor.entity.Liquor
import record.liquors.liquor.entity.LiquorCategory
import record.liquors.liquor.entity.LiquorRating

data class LiquorResponse(
    val name: String,

    val rating: LiquorRating,

    var review: String?,

    var category: LiquorCategory,

    var id: Long? = null
) {
    companion object {
        fun toDto(liquor: Liquor): LiquorResponse {
            return LiquorResponse(
                name = liquor.name,
                rating = liquor.rating,
                review = liquor.review,
                category = liquor.category,
                id = liquor.id
            )
        }
    }
}
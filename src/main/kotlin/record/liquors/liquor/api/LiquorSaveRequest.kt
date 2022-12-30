package record.liquors.liquor.api

import record.liquors.liquor.entity.Liquor
import record.liquors.liquor.entity.LiquorRating
import javax.validation.constraints.NotBlank

data class LiquorSaveRequest(
    @NotBlank
    val name: String,
    @NotBlank
    val rating: LiquorRating,
    var review: String?,
    var category: String?,
) {
    companion object {
        fun toEntity(request: LiquorSaveRequest): Liquor {
            return Liquor(
                name = request.name,
                rating = request.rating,
                review = request.review,
                category = request.category
            );
        }
    }
}
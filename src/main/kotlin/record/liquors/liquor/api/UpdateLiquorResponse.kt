package record.liquors.liquor.api

import record.liquors.liquor.entity.Liquor
import record.liquors.liquor.entity.LiquorRating

data class UpdateLiquorResponse(
  val id: Long,
  val name: String,
  val rating: LiquorRating,
  var review: String?,
  var category: String?,
) {
  companion object {
    fun toDto(liquor: Liquor): UpdateLiquorResponse {
      return UpdateLiquorResponse(
        id = liquor.id!!,
        name = liquor.name,
        rating = liquor.rating,
        review = liquor.review,
        category = liquor.category,
      )
    }
  }
}
package record.liquors.liquor.api

import record.liquors.liquor.entity.Liquor
import record.liquors.liquor.entity.LiquorCategory
import record.liquors.liquor.entity.LiquorRating
import record.liquors.liquor.entity.Review

data class UpdateLiquorResponse(
  val id: Long,
  val name: String,
  val rating: LiquorRating,
  var category: LiquorCategory,
) {
  companion object {
    fun toDto(liquor: Liquor): UpdateLiquorResponse {
      return UpdateLiquorResponse(
        id = liquor.id!!,
        name = liquor.name,
        rating = liquor.rating,
        category = liquor.category,
      )
    }
  }
}
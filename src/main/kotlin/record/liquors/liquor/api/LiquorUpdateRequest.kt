package record.liquors.liquor.api

import record.liquors.liquor.entity.LiquorRating
import javax.validation.constraints.NotBlank

data class LiquorUpdateRequest(
  @NotBlank
  val name: String,
  @NotBlank
  val rating: LiquorRating,
  var categoryId: Long,
)
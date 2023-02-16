package record.liquors.liquor.api

import record.liquors.liquor.entity.Liquor
import record.liquors.liquor.entity.LiquorCategory
import record.liquors.liquor.entity.LiquorRating
import javax.validation.constraints.NotBlank

data class LiquorSaveRequest(
    @NotBlank
    val name: String,
    @NotBlank
    val price: Int,
    @NotBlank
    var categoryId: Long,
)
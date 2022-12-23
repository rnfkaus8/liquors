package record.liquors.liquor.entity

import record.liquors.base.BaseEntityModel
import javax.persistence.*

@Entity
class Liquor(

    val name: String,

    @Enumerated(EnumType.STRING)
    val rating: LiquorRating,

    val review: String,

    val category: String,

    @Id @GeneratedValue
    var id: Long? = null
) : BaseEntityModel()
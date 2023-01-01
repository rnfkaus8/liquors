package record.liquors.liquor.entity

import record.liquors.base.BaseEntityModel
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Liquor(

    var name: String,

    @Enumerated(EnumType.STRING)
    var rating: LiquorRating,

    var review: String?,

    var category: String?,

    @Id @GeneratedValue
    var id: Long? = null
) : BaseEntityModel() {
    fun update(name: String, rating: LiquorRating, review: String?, category: String?) {
        this.name = name
        this.rating = rating
        this.review = review
        this.category = category
        this.updatedAt = LocalDateTime.now()
    }
}
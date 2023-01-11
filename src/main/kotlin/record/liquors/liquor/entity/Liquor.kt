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

    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: LiquorCategory,

    @Id @GeneratedValue
    var id: Long? = null
) : BaseEntityModel() {
    fun update(name: String, rating: LiquorRating, review: String?, category: LiquorCategory) {
        this.name = name
        this.rating = rating
        this.review = review
        this.category = category
        this.updatedAt = LocalDateTime.now()
    }
}
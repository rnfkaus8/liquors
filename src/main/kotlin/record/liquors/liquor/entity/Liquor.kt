package record.liquors.liquor.entity

import record.liquors.base.BaseEntityModel
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Liquor(

    var name: String,

    @Enumerated(EnumType.STRING)
    var rating: LiquorRating,

    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: LiquorCategory,

    @OneToMany
    @JoinColumn(name = "review_id")
    var review: MutableList<Review> = mutableListOf(),

    @Id @GeneratedValue
    var id: Long? = null
) : BaseEntityModel() {
    fun update(name: String, rating: LiquorRating, category: LiquorCategory) {
        this.name = name
        this.rating = rating
        this.category = category
        this.updatedAt = LocalDateTime.now()
    }

    fun addReview(review: Review) {
        this.review.add(review)
    }
}
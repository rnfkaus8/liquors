package record.liquors.liquor.entity

import record.liquors.base.BaseEntityModel
import java.time.LocalDateTime
import javax.persistence.*
import javax.persistence.FetchType.LAZY

@Entity
class Liquor(
  
  var name: String,
  
  var price: Int,
  
  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "category_id")
  var category: LiquorCategory,
  
  @OneToMany(fetch = LAZY)
  @JoinColumn(name = "review_id")
  var review: MutableList<Review> = mutableListOf(),
  
  @Id @GeneratedValue
  var id: Long? = null
) : BaseEntityModel() {
  fun update(name: String, price: Int, category: LiquorCategory) {
    this.name = name
    this.price = price
    this.category = category
    this.updatedAt = LocalDateTime.now()
  }
  
  fun addReview(review: Review) {
    this.review.add(review)
  }
}
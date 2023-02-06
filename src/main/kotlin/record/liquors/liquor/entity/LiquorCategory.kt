package record.liquors.liquor.entity

import org.hibernate.Hibernate
import javax.persistence.*
import javax.persistence.FetchType.LAZY

@Entity
class LiquorCategory(
  val categoryName: String,
  
  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "parent_category_id")
  var parent: LiquorCategory? = null,
  
  @OneToMany(mappedBy = "parent", cascade = [CascadeType.ALL])
  var children: MutableList<LiquorCategory> = mutableListOf(),
  
  @Id @GeneratedValue
  var id: Long? = null
) {
  
  fun addChildCategory(child: LiquorCategory) {
    this.children.add(child)
    child.parent = this
  }
  
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
    other as LiquorCategory
    
    return id != null && id == other.id
  }
  
  override fun hashCode(): Int = javaClass.hashCode()
  
}
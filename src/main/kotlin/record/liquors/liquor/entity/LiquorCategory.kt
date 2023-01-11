package record.liquors.liquor.entity

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class LiquorCategory(
    val categoryName: String,

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    var parent: LiquorCategory? = null,

    @OneToMany(mappedBy = "parent", cascade = [CascadeType.ALL])
    var children: List<LiquorCategory> = listOf(),

    @Id @GeneratedValue
    var id: Long? = null
)
package record.liquors.liquors.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class LiquorCategory(

    val name: String,

    @ManyToOne
    @JoinColumn(name = "parent_id")
    var parent: LiquorCategory? = null,

    @OneToMany(mappedBy = "parent")
    var child: MutableList<LiquorCategory> = mutableListOf(),

    @Id @GeneratedValue
    var id: Long? = null
) {
    fun addChildCategory(child: LiquorCategory) {
        this.child.add(child)
        child.parent = this
    }

}

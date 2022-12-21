package record.liquors.liquors.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class LiquorCategory(
    @Column(name = "name")
    val name: String,

    @Id @GeneratedValue
    var id: Long? = null
)

package record.liquors.liquors.entity

import javax.persistence.*

@Entity
class Liquor(

    val name: String,

    @Enumerated(EnumType.STRING)
    val rating: LiquorRating,

    val review: String,

    @ManyToOne
    @JoinColumn(name = "name")
    val category: LiquorCategory,

    @Id @GeneratedValue
    var id: Long? = null
)
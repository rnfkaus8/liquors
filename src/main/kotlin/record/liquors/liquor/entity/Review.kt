package record.liquors.liquor.entity

import javax.persistence.*

@Entity
class Review(
    @Lob
    var content: String,

    @Enumerated(EnumType.STRING)
    var rating: LiquorRating,

    @ManyToOne
    @JoinColumn(name = "liquor_id")
    var liquor: Liquor,

    @Id @GeneratedValue
    var id: Long? = null
) {
    fun changeContent(content: String) {
        this.content = content
    }
}
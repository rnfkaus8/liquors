package record.liquors.liquor.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Lob

@Entity
class Review(
    @Lob
    var content: String,
    @Id @GeneratedValue
    var id: Long?
) {
    fun changeContent(content: String) {
        this.content = content
    }
}
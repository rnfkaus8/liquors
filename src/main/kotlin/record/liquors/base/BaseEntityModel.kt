package record.liquors.base

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(value = ([AuditingEntityListener::class]))
class BaseEntityModel {

  @CreatedDate
  @Column(name = "createdAt")
  lateinit var createdAt: LocalDateTime

  @LastModifiedBy
  @Column(name = "updatedAt")
  lateinit var updatedAt: LocalDateTime
}
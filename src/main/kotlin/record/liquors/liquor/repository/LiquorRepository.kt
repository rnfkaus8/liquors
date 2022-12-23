package record.liquors.liquor.repository

import org.springframework.data.jpa.repository.JpaRepository
import record.liquors.liquor.entity.Liquor

interface LiquorRepository : JpaRepository<Liquor, Long> {
}
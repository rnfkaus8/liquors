package record.liquors.liquor.repository

import org.springframework.data.jpa.repository.JpaRepository
import record.liquors.liquor.entity.LiquorCategory

interface LiquorCategoryRepository: JpaRepository<LiquorCategory, Long>
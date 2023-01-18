package record.liquors.liquor.repository

import org.springframework.data.jpa.repository.JpaRepository
import record.liquors.liquor.entity.Review

interface ReviewRepository: JpaRepository<Review, Long>
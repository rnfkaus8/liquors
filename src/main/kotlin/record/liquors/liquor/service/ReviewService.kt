package record.liquors.liquor.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import record.liquors.liquor.entity.Review
import record.liquors.liquor.repository.ReviewRepository

@Service
@Transactional(readOnly = true)
class ReviewService(
    val reviewRepository: ReviewRepository
) {
    @Transactional
    fun save(request: Review): Long {
        reviewRepository.save(request)
        return request.id!!
    }

    fun findOne(id: Long): Review {
        return reviewRepository.findById(id).orElseThrow {  throw NoSuchElementException("review not found")}
    }

    fun findAll(): List<Review> {
        return reviewRepository.findAll()
    }
}
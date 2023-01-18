package record.liquors.liquor.repository

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import record.liquors.liquor.entity.Review

@SpringBootTest
@Transactional
class ReviewRepositoryTest(
    @Autowired val reviewRepository: ReviewRepository
) {
    @Test
    fun `save and findOne`() {
        // given
        val review = Review(content = "리뷰입니당.")
        reviewRepository.save(review)
        // when
        val findReview = reviewRepository.findById(review.id!!).get()
        // then
        assertThat(findReview).isEqualTo(review)
    }
}
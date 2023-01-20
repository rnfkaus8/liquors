package record.liquors.liquor.repository

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import record.liquors.liquor.entity.Liquor
import record.liquors.liquor.entity.LiquorCategory
import record.liquors.liquor.entity.LiquorRating
import record.liquors.liquor.entity.Review

@SpringBootTest
@Transactional
class LiquorRepositoryTest(
  @Autowired
  val liquorRepository: LiquorRepository,
  @Autowired
  val liquorCategoryRepository: LiquorCategoryRepository,
  @Autowired
  val reviewRepository: ReviewRepository,
) {

  @Test
  fun `liquor insert test`() {
    val liquorCategory = LiquorCategory(categoryName = "위스키")
    liquorCategoryRepository.save(liquorCategory)
    val liquor = Liquor(
      name = "버팔로 트레이스",
      rating = LiquorRating.VERY_GOOD,
      category = liquorCategory
    )
    liquorRepository.save(liquor)

    val findLiquor = liquorRepository.findById(liquor.id!!).get()

    assertThat(findLiquor).isEqualTo(liquor)
    assertThat(findLiquor.name).isEqualTo(liquor.name)
  }
  
  @Test
  fun `find liquors`() {
    //given
    val parent = LiquorCategory("위스키")
    val child = LiquorCategory("버번 위스키")
    parent.addChildCategory(child)
    liquorCategoryRepository.save(parent)
    liquorCategoryRepository.save(child)
    val buffaloTraceReview = Review(content = "버번 위스키의 입문용으로 딱이얌")
    reviewRepository.save(buffaloTraceReview)
    val buffaloTrace = Liquor(
      name = "버팔로 트레이스",
      rating = LiquorRating.VERY_GOOD,
      category = child
    )
    buffaloTrace.addReview(buffaloTraceReview)

    val wildTurkey = Liquor(
      name = "와일드 터키",
      rating = LiquorRating.VERY_GOOD,
      category = child
    )
    val makersMark = Liquor(
      name = "메이커스 마크",
      rating = LiquorRating.VERY_GOOD,
      category = child
    )
    liquorRepository.save(buffaloTrace)
    liquorRepository.save(wildTurkey)
    liquorRepository.save(makersMark)

    //when
    val findLiquors = liquorRepository.findAll()

    //then
    assertThat(findLiquors).contains(buffaloTrace, wildTurkey, makersMark)

  }
}
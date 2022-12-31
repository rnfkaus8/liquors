package record.liquors.liquor.repository

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import record.liquors.liquor.entity.Liquor
import record.liquors.liquor.entity.LiquorRating

@SpringBootTest
class LiquorRepositoryTest(
  @Autowired
  val liquorRepository: LiquorRepository
) {

  @Test
  fun `liquor insert test`() {
    val liquor = Liquor(
      name = "버팔로 트레이스",
      rating = LiquorRating.VERY_GOOD,
      review = "버번 위스키의 입문용으로 딱이얌",
      category = "버번 위스키"
    )
    liquorRepository.save(liquor)

    val findLiquor = liquorRepository.findById(liquor.id!!).get()

    assertThat(findLiquor).isEqualTo(liquor)
    assertThat(findLiquor.name).isEqualTo(liquor.name)
  }
}
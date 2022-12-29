package record.liquors.liquor.service

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import record.liquors.liquor.api.LiquorSaveRequest
import record.liquors.liquor.entity.Liquor
import record.liquors.liquor.entity.LiquorRating

@SpringBootTest
class LiquorServiceTest(
    @Autowired val liquorService: LiquorService
) {

    @Test
    fun save() {
        val liquor = Liquor(name = "버팔로 트레이스", LiquorRating.VERY_GOOD, review = "review", category = "cate")
        liquorService.save(LiquorSaveRequest(name = liquor.name, rating = liquor.rating, review = liquor.review, category = liquor.category))

        val findLiquor = liquorService.findById(liquor.id!!)

        assertThat(findLiquor.id).isEqualTo(liquor.id)
    }
}
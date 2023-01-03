package record.liquors.liquor.service

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import record.liquors.liquor.api.LiquorResponse
import record.liquors.liquor.api.LiquorSaveRequest
import record.liquors.liquor.entity.Liquor
import record.liquors.liquor.entity.LiquorRating
import record.liquors.liquor.repository.LiquorRepository

@SpringBootTest
class LiquorServiceTest(
    @Autowired val liquorService: LiquorService,
    @Autowired val liquorRepository: LiquorRepository
) {

    @Test
    fun save() {
        val liquor = Liquor(name = "버팔로 트레이스", LiquorRating.VERY_GOOD, review = "review", category = "cate")
        liquorService.save(LiquorSaveRequest(name = liquor.name, rating = liquor.rating, review = liquor.review, category = liquor.category))

        val findLiquor = liquorService.findOne(liquor.id!!)

        assertThat(findLiquor.id).isEqualTo(liquor.id)
    }

    @Test
    fun findAll() {
        val liquor1 = Liquor(name = "버팔로 트레이스", LiquorRating.VERY_GOOD, review = "review", category = "cate")
        val liquor2 = Liquor(name = "메이커스 마크", LiquorRating.VERY_GOOD, review = "review", category = "cate")
        val liquor3 = Liquor(name = "와일드 터키", LiquorRating.VERY_GOOD, review = "review", category = "cate")
        liquorRepository.save(liquor1)
        liquorRepository.save(liquor2)
        liquorRepository.save(liquor3)

        val findLiquors = liquorService.findLiquors()

        assertThat(findLiquors).isEqualTo(listOf(LiquorResponse.toDto(liquor1), LiquorResponse.toDto(liquor2), LiquorResponse.toDto(liquor3)))
    }


}
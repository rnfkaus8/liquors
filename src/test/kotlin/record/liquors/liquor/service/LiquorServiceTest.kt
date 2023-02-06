package record.liquors.liquor.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.transaction.annotation.Transactional
import record.liquors.liquor.api.LiquorResponse
import record.liquors.liquor.api.LiquorSaveRequest
import record.liquors.liquor.api.LiquorUpdateRequest
import record.liquors.liquor.entity.Liquor
import record.liquors.liquor.entity.LiquorCategory
import record.liquors.liquor.entity.LiquorRating
import record.liquors.liquor.repository.LiquorCategoryRepository
import record.liquors.liquor.repository.LiquorRepository

@SpringBootTest
@Transactional
class LiquorServiceTest(
	@Autowired val liquorService: LiquorService,
	@Autowired val liquorRepository: LiquorRepository,
	@Autowired val liquorCategoryRepository: LiquorCategoryRepository,
) {
	
	@Test
	fun save() {
		val parentCategory = LiquorCategory(categoryName = "위스키")
		val childCategory = LiquorCategory(categoryName = "버번 위스키", parent = parentCategory)
		parentCategory.addChildCategory(childCategory)
		liquorCategoryRepository.save(parentCategory)
		liquorCategoryRepository.save(childCategory)
		
		val liquor = Liquor(name = "버팔로 트레이스", rating = LiquorRating.VERY_GOOD, price = 50000, category = childCategory)
		liquorService.save(
			LiquorSaveRequest(
				name = liquor.name,
				rating = liquor.rating,
				review = "맛있어용",
				categoryId = liquor.category.id!!,
				price = liquor.price
			)
		)
		
		val findLiquor = liquorService.findOne(liquor.id!!)
		
		assertThat(findLiquor.id).isEqualTo(liquor.id)
	}
	
	@Test
	fun findAll() {
		val parentCategory = LiquorCategory(categoryName = "위스키")
		val childCategory = LiquorCategory(categoryName = "버번 위스키", parent = parentCategory)
		parentCategory.addChildCategory(childCategory)
		liquorCategoryRepository.save(parentCategory)
		liquorCategoryRepository.save(childCategory)
		
		val liquor1 =
			Liquor(name = "버팔로 트레이스", rating = LiquorRating.VERY_GOOD, price = 50000, category = childCategory)
		val liquor2 = Liquor(name = "메이커스 마크", rating = LiquorRating.VERY_GOOD, price = 50000, category = childCategory)
		val liquor3 = Liquor(name = "와일드 터키", rating = LiquorRating.VERY_GOOD, price = 50000, category = childCategory)
		
		liquorRepository.save(liquor1)
		liquorRepository.save(liquor2)
		liquorRepository.save(liquor3)
		
		val findLiquors = liquorService.findLiquors(PageRequest.of(0, 2))

		for (findLiquor in findLiquors) {
			println("hello : $findLiquor")
		}

//		assertThat(findLiquors).isEqualTo(listOf(LiquorResponse.toDto(liquor1), LiquorResponse.toDto(liquor2)))
	}
	
	@Test
	fun update() {
		// given
		val parentCategory = LiquorCategory(categoryName = "위스키")
		val childCategory = LiquorCategory(categoryName = "버번 위스키", parent = parentCategory)
		parentCategory.addChildCategory(childCategory)
		liquorCategoryRepository.save(parentCategory)
		liquorCategoryRepository.save(childCategory)
		val liquor = Liquor(name = "버팔로 트레이스", rating = LiquorRating.VERY_GOOD, price = 50000, category = childCategory)
		liquorRepository.save(liquor)
		
		// when
		val updateLiquorId = liquorService.update(
			liquor.id!!,
			LiquorUpdateRequest(name = "메이커스 마크", rating = LiquorRating.VERY_GOOD, price = 50000, categoryId = childCategory.id!!)
		)
		
		val findUpdateLiquor = liquorService.findOne(updateLiquorId)
		println(findUpdateLiquor.review)
		println(findUpdateLiquor.category)
		// then
		assertThat(liquor.id!!).isEqualTo(updateLiquorId)
		assertThat(findUpdateLiquor.name).isEqualTo("메이커스 마크")
	}
	
	
}
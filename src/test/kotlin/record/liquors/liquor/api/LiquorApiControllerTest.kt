package record.liquors.liquor.api

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import record.liquors.liquor.entity.Liquor
import record.liquors.liquor.entity.LiquorCategory
import record.liquors.liquor.entity.LiquorRating
import record.liquors.liquor.repository.LiquorCategoryRepository
import record.liquors.liquor.repository.LiquorRepository
import record.liquors.liquor.service.LiquorService

@SpringBootTest
@AutoConfigureMockMvc
class LiquorApiControllerTest(
    @Autowired
    val liquorRepository: LiquorRepository,
    @Autowired
    val liquorCategoryRepository: LiquorCategoryRepository,

    @Autowired
    val mockMvc: MockMvc,

    @Autowired
    val objectMapper: ObjectMapper
) {
    @Test
    fun save() {
        val content = objectMapper.writeValueAsString(
            LiquorSaveRequest(
                name = "name1",
                rating = LiquorRating.VERY_GOOD,
                review = null,
                categoryId = 0L
            )
        )
        mockMvc.perform(
            post("/liquor")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)

    }

    @Test
    fun findOne() {
        val parentCategory = LiquorCategory(categoryName = "위스키")
        val childCategory = LiquorCategory(categoryName = "버번 위스키", parent = parentCategory)
        parentCategory.addChildCategory(childCategory)
        liquorCategoryRepository.save(parentCategory)
        liquorCategoryRepository.save(childCategory)
        val liquor = Liquor(name = "버팔로 트레이스", LiquorRating.VERY_GOOD, review = "review", category = childCategory)
        liquorRepository.save(liquor)
        liquorRepository.flush()

        mockMvc.perform(
            get("/liquor/{id}", liquor.id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
    }

    @Test
    fun findAll() {
        val parentCategory = LiquorCategory(categoryName = "위스키")
        val childCategory = LiquorCategory(categoryName = "버번 위스키", parent = parentCategory)
        parentCategory.addChildCategory(childCategory)
        liquorCategoryRepository.save(parentCategory)
        liquorCategoryRepository.save(childCategory)
        val liquor1 = Liquor(name = "버팔로 트레이스", LiquorRating.VERY_GOOD, review = "review", category = childCategory)
        liquorRepository.save(liquor1)
        liquorRepository.flush()
        val liquor2 = Liquor(name = "버팔로 트레이스", LiquorRating.VERY_GOOD, review = "review", category = childCategory)
        liquorRepository.save(liquor2)
        liquorRepository.flush()
        val liquor3 = Liquor(name = "버팔로 트레이스", LiquorRating.VERY_GOOD, review = "review", category = childCategory)
        liquorRepository.save(liquor3)
        liquorRepository.flush()
    }

}
package record.liquors.liquor.repository

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import record.liquors.liquor.entity.LiquorCategory

@SpringBootTest
class LiquorCategoryRepositoryTest(
    @Autowired val liquorCategoryRepository: LiquorCategoryRepository
) {

    @Test
    fun `category parent save`() {
        // given
        val category = LiquorCategory("위스키")
        liquorCategoryRepository.save(category)

        // when
        val findCategory = liquorCategoryRepository.findById(category.id!!).get()

        // then
        assertThat(findCategory).isEqualTo(category)
    }

}
package record.liquors.liquor.repository

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import record.liquors.liquor.entity.LiquorCategory

@SpringBootTest
@Transactional
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

    @Test
    fun `category child save`() {
        //given
        val parent = LiquorCategory("위스키")
        val child = LiquorCategory("버번 위스키", parent = parent)
        parent.addChildCategory(child)

        liquorCategoryRepository.save(parent)
        liquorCategoryRepository.save(child)

        //when
        val findParent = liquorCategoryRepository.findById(parent.id!!).get()
        val findChild = liquorCategoryRepository.findById(child.id!!).get()

        //then
        assertThat(findParent).isEqualTo(parent)
        assertThat(findParent.children).containsAll(listOf(findChild))
        assertThat(findChild.parent).isEqualTo(parent)

    }

}
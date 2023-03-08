package memo.liquor.myliquor.repository;

import memo.liquor.myliquor.entity.Category;
import memo.liquor.myliquor.entity.Liquor;
import memo.liquor.myliquor.entity.LiquorCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LiquorRepositoryTest {

    @Autowired
    private LiquorRepository liquorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LiquorCategoryRepository liquorCategoryRepository;

    @Test
    public void save() {

        Liquor liquor = Liquor.builder().name("주류").build();
        liquorRepository.save(liquor);

        Category category = Category.builder().name("버번").build();
        categoryRepository.save(category);

        LiquorCategory liquorCategory = LiquorCategory.builder().category(category).liquor(liquor).build();
        liquorCategoryRepository.save(liquorCategory);


        System.out.println(liquorCategory.getLiquor().getName());

    }
}
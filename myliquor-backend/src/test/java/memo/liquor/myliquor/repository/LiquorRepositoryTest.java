package memo.liquor.myliquor.repository;

import memo.liquor.myliquor.entity.Category;
import memo.liquor.myliquor.entity.Liquor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class LiquorRepositoryTest {

  @Autowired
  private LiquorRepository liquorRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Test
  public void save() {

    Liquor liquor = Liquor.builder().name("주류").build();
    liquorRepository.save(liquor);

    Category category = Category.builder().name("버번").build();
    categoryRepository.save(category);

  }
}
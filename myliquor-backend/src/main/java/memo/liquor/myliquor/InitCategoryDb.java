package memo.liquor.myliquor;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import memo.liquor.myliquor.entity.Category;
import memo.liquor.myliquor.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitCategoryDb {
  private final InitService initService;

  @PostConstruct
  public void init() {
    initService.categoryDbInit();
  }

  @Component
  @Transactional
  @RequiredArgsConstructor
  static class InitService {
    private final CategoryRepository categoryRepository;

    public void categoryDbInit() {
      categoryRepository.save(Category.builder().name("싱글 몰트").build());
      categoryRepository.save(Category.builder().name("블렌디드").build());
      categoryRepository.save(Category.builder().name("그레인").build());
      categoryRepository.save(Category.builder().name("쉐리").build());
      categoryRepository.save(Category.builder().name("버번").build());
      categoryRepository.save(Category.builder().name("피트").build());
      categoryRepository.save(Category.builder().name("스카치").build());
      categoryRepository.save(Category.builder().name("아이리시").build());
      categoryRepository.save(Category.builder().name("아메리칸").build());
      categoryRepository.save(Category.builder().name("재패니스").build());
      categoryRepository.save(Category.builder().name("기타").build());
    }
  }
}

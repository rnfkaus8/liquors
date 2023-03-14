package memo.liquor.myliquor.controller;

import lombok.RequiredArgsConstructor;
import memo.liquor.myliquor.entity.Category;
import memo.liquor.myliquor.entity.Liquor;
import memo.liquor.myliquor.repository.CategoryRepository;
import memo.liquor.myliquor.repository.LiquorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LiquorController {

  private final CategoryRepository categoryRepository;
  private final LiquorRepository liquorRepository;

  @GetMapping("/categories")
  public List<Category> findAllCategories() {
    return categoryRepository.findAll();
  }

  @PostMapping("/liquor")
  public Long saveLiquor(@RequestBody SaveLiquorRequest request) {
    Category findCategory = categoryRepository.findById(request.getCategoryId()).get();
    Liquor liquor = Liquor.builder().name(request.getName()).category(findCategory).build();
    liquorRepository.save(liquor);
    return liquor.getId();
  }


}

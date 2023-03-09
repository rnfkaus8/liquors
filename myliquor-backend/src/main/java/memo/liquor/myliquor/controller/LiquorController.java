package memo.liquor.myliquor.controller;

import lombok.RequiredArgsConstructor;
import memo.liquor.myliquor.entity.Category;
import memo.liquor.myliquor.repository.CategoryRepository;
import memo.liquor.myliquor.repository.LiquorRepository;
import org.springframework.web.bind.annotation.GetMapping;
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


}

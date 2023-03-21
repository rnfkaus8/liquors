package memo.liquor.myliquor.controller;

import lombok.RequiredArgsConstructor;
import memo.liquor.myliquor.entity.Category;
import memo.liquor.myliquor.repository.CategoryRepository;
import memo.liquor.myliquor.service.LiquorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LiquorController {

  private final CategoryRepository categoryRepository;
  private final LiquorService liquorService;

  @GetMapping("/categories")
  public List<Category> findAllCategories() {
    return categoryRepository.findAll();
  }

  @PostMapping("/liquor")
  public Long saveLiquor(@RequestBody SaveLiquorRequest request) {
    return liquorService.save(request);
  }

  @GetMapping("/liquors")
  public List<LiquorResponse> getLiquors() {
    return liquorService.findAll();
  }

  @GetMapping("/liquor/{id}")
  public LiquorResponse getLiquor(@PathVariable Long id) {
    return liquorService.findById(id);
  }

}

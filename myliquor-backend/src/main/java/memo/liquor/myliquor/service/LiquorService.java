package memo.liquor.myliquor.service;

import lombok.RequiredArgsConstructor;
import memo.liquor.myliquor.controller.LiquorResponse;
import memo.liquor.myliquor.controller.SaveLiquorRequest;
import memo.liquor.myliquor.controller.SavedLiquorResponse;
import memo.liquor.myliquor.entity.Category;
import memo.liquor.myliquor.entity.Liquor;
import memo.liquor.myliquor.repository.CategoryRepository;
import memo.liquor.myliquor.repository.LiquorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LiquorService {
  private final LiquorRepository liquorRepository;
  private final CategoryRepository categoryRepository;

  public SavedLiquorResponse save(SaveLiquorRequest request) {
    Category findCategory = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new IllegalArgumentException("카테고리가 없습니다"));
    Liquor liquor = Liquor.builder().name(request.getName()).category(findCategory).build();
    liquorRepository.save(liquor);
    return SavedLiquorResponse.builder().id(liquor.getId()).name(liquor.getName()).build();
  }

  public List<LiquorResponse> findAll() {
    return liquorRepository.findAll().stream().map((liquor) -> {
      return LiquorResponse.builder().id(liquor.getId()).name(liquor.getName()).category(liquor.getCategory()).build();
    }).toList();
  }
}

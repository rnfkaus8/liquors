package memo.liquor.myliquor.service;

import lombok.RequiredArgsConstructor;
import memo.liquor.myliquor.controller.LiquorResponse;
import memo.liquor.myliquor.controller.SaveLiquorRequest;
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

  public Long save(SaveLiquorRequest request) {
    Category findCategory = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new IllegalStateException("카테고리가 없습니다"));
    Liquor liquor = Liquor.builder().name(request.getName()).category(findCategory).price(request.getPrice()).rating(request.getRating()).build();
    liquorRepository.save(liquor);
    return liquor.getId();
  }

  public List<LiquorResponse> findAll() {
    return liquorRepository.findAll().stream().map((liquor) -> {
      return LiquorResponse
          .builder()
          .id(liquor.getId())
          .name(liquor.getName())
          .categoryId(liquor.getCategory().getId())
          .categoryName(liquor.getCategory().getName())
          .build();
    }).toList();

  }

  public LiquorResponse findById(Long id) {
    Liquor findLiquor = liquorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 아이디입니다."));
    return LiquorResponse
        .builder()
        .id(findLiquor.getId())
        .name(findLiquor.getName())
        .categoryId(findLiquor.getCategory().getId())
        .categoryName(findLiquor.getCategory().getName())
        .build();
  }
}

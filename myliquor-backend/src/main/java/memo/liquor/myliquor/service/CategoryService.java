package memo.liquor.myliquor.service;

import lombok.RequiredArgsConstructor;
import memo.liquor.myliquor.controller.CategoryResponse;
import memo.liquor.myliquor.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
  private final CategoryRepository categoryRepository;

  public List<CategoryResponse> findAll() {
    return categoryRepository.findAll().stream().map((category -> {
      return CategoryResponse.builder().id(category.getId()).name(category.getName()).build();
    })).toList();
  }
}

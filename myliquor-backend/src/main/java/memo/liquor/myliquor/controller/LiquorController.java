package memo.liquor.myliquor.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import memo.liquor.myliquor.service.CategoryService;
import memo.liquor.myliquor.service.FileSystemStorageService;
import memo.liquor.myliquor.service.LiquorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LiquorController {

  private final CategoryService categoryService;
  private final LiquorService liquorService;
  private final FileSystemStorageService fileSystemStorageService;

  @GetMapping("/categories")
  public List<CategoryResponse> findAllCategories() {
    return categoryService.findAll();
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

  @PostMapping("/review")
  public void saveReview(MultipartFile image, Long liquorId) throws Exception {
    File file = new File("/upload/" + image.getOriginalFilename());
    image.transferTo(file);
    fileSystemStorageService.store(image);

  }

}

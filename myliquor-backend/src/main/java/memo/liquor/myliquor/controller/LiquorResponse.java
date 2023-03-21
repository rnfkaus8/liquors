package memo.liquor.myliquor.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class LiquorResponse {
  private final Long id;
  private final String name;
  // TODO CategoryResponse 객체를 추가해야할 필요성이 보인다
  private final Long categoryId;
  private final String categoryName;
}

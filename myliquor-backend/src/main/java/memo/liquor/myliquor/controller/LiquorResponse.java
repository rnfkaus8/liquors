package memo.liquor.myliquor.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import memo.liquor.myliquor.entity.Category;

@Getter
@Builder
@RequiredArgsConstructor
public class LiquorResponse {
  private final Long id;
  private final String name;
  private final Category category;

}

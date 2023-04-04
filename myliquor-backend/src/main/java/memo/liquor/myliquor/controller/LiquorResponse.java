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
  private final CategoryResponse category;
}

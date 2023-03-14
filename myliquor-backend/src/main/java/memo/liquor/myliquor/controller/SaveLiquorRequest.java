package memo.liquor.myliquor.controller;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SaveLiquorRequest {
  private String name;
  private Long categoryId;
}

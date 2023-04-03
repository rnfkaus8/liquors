package memo.liquor.myliquor.controller;

import jakarta.validation.constraints.Max;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SaveLiquorRequest {
  private String name;
  private Long categoryId;
  private Integer price;
  @Max(5)
  private Integer rating;
}

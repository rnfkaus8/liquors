package memo.liquor.myliquor.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Liquor {

  @Id
  @GeneratedValue
  @Column(name = "liquor_id")
  private Long id;

  private String name;

  private Integer price;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;


  @OneToMany(fetch = FetchType.LAZY)
  private List<Review> reviews = new ArrayList();

  @Builder
  public Liquor(String name, Category category, Integer price) {
    this.name = name;
    this.category = category;
    this.price = price;
  }
}

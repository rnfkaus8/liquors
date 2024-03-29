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

  private Integer rating;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;

  @OneToMany(fetch = FetchType.LAZY)
  private List<Review> reviews = new ArrayList();


  @Builder
  public Liquor(Long id, String name, Integer price, Integer rating, Category category) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.rating = rating;
    this.category = category;
  }
}

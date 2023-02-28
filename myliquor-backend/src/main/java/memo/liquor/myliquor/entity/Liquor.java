package memo.liquor.myliquor.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Liquor {

    @Id
    @GeneratedValue
    @Column(name = "liquor_id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String imgName;

    private String imgPath;

    public void setCategory(Category category) {
        this.category = category;
    }

    @Builder
    public Liquor(String name, Category category, String imgName, String imgPath) {
        this.name = name;
        this.category = category;
        this.imgName = imgName;
        this.imgPath = imgPath;
    }
}

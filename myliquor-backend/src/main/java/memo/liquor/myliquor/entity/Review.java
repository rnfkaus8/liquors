package memo.liquor.myliquor.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    private int rating;

    private String content;

    private String imgName;

    private String imgPath;

    @ManyToOne
    @JoinColumn(name = "liquor_id")
    private Liquor liquor;

    public Review(int rating, String content, String imgName, String imgPath, Liquor liquor) {
        this.rating = rating;
        this.content = content;
        this.imgName = imgName;
        this.imgPath = imgPath;
        this.liquor = liquor;
    }
}
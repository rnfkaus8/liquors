package memo.liquor.myliquor.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LiquorCategory {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "liquor_id")
    private Liquor liquor;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
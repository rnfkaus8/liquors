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

    @OneToMany(mappedBy = "liquor")
    private List<LiquorCategory> categorise = new ArrayList();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList();

    @Builder
    public Liquor(String name, List<LiquorCategory> categorise) {
        this.name = name;
        this.categorise.addAll(categorise);
    }
}

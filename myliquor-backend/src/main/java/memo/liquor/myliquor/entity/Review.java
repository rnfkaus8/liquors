package memo.liquor.myliquor.entity;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    private int rating;

    private String content;

    @ManyToOne
    @JoinColumn(name = "liquor_id")
    private Liquor liquor;


}
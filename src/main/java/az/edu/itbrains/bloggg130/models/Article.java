package az.edu.itbrains.bloggg130.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 10000)
    private String description;
    private Long view;
    private Date createDate;
    private Date updateDate;
    private String photoUrl;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}

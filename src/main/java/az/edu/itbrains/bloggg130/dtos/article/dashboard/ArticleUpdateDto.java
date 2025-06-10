package az.edu.itbrains.bloggg130.dtos.article.dashboard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUpdateDto {
    private String title;
    private String description;
    private Long view;
    private String photoUrl;
    private Long categoryId;
}

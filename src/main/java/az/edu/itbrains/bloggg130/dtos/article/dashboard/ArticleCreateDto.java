package az.edu.itbrains.bloggg130.dtos.article.dashboard;

import az.edu.itbrains.bloggg130.dtos.category.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCreateDto {
    private String title;
    private String editor1;
    private String photoUrl;
    private Long categoryId;
}

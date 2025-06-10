package az.edu.itbrains.bloggg130.dtos.category;

import az.edu.itbrains.bloggg130.dtos.article.ArticleHomeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryPopularDto {
    private Long id;
    private String name;
    private int count;
    private List<ArticleHomeDto> articles;

    public int getCount() {
        return articles.size();
    }
}

package az.edu.itbrains.bloggg130.dtos.article;

import az.edu.itbrains.bloggg130.dtos.category.CategoryDto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDetailDto {
    private Long id;
    private String title;
    private String description;
    private Long view;
    private Date createDate;
    private String photoUrl;
    private CategoryDto category;
}

package az.edu.itbrains.bloggg130.dtos.article.dashboard;

import az.edu.itbrains.bloggg130.dtos.category.CategoryDto;
import az.edu.itbrains.bloggg130.models.Category;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDashboardDto {
    private Long id;
    private String title;
    private String description;
    private Long view;
    private String photoUrl;
    private CategoryDto category;
}

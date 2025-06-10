package az.edu.itbrains.bloggg130.dtos.article;

import az.edu.itbrains.bloggg130.dtos.category.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCategoryDto {
    private Long id;
    private String title;
    private String description;
    private String photoUrl;
    private Date updateDate;
    private CategoryDto category;


    public String getDescription() {
        return description.substring(0,166)+"...";
    }
}

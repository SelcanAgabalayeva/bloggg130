package az.edu.itbrains.bloggg130.dtos.article;

import az.edu.itbrains.bloggg130.dtos.category.CategoryDto;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleFeedDto {
    private Long id;
    private String title;
    private String description;
    private String photoUrl;
    private Date updateDate;
    private CategoryDto category;

    public String getDescription() {
        if (description == null) {
            return "";
        }
        return description.length() > 166
                ? description.substring(0, 166) + "..."
                : description;
    }

}

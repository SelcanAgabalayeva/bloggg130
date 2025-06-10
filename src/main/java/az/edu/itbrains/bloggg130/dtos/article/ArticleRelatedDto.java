package az.edu.itbrains.bloggg130.dtos.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRelatedDto {
    private Long id;
    private String title;
    private Date createDate;
    private String photoUrl;
}

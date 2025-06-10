package az.edu.itbrains.bloggg130.dtos.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleBannerDto {
    private Long id;
    private String title;
    private String photoUrl;
    private Date updateDate;
}

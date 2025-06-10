package az.edu.itbrains.bloggg130.repositories;

import az.edu.itbrains.bloggg130.models.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    Page<Article> findByCategoryId(Long categoryId, Pageable pageable);
    @Query(nativeQuery = true,value = "SELECT * FROM articles WHERE category_id = :categoryId AND id != :articleId LIMIT 2")
    List<Article> findRelatedArticle(Long categoryId,Long articleId);

    List<Article> findByTitle(String text);
}

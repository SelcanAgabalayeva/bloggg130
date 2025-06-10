package az.edu.itbrains.bloggg130.services;

import az.edu.itbrains.bloggg130.dtos.article.*;
import az.edu.itbrains.bloggg130.dtos.article.dashboard.ArticleCreateDto;
import az.edu.itbrains.bloggg130.dtos.article.dashboard.ArticleDashboardDto;
import az.edu.itbrains.bloggg130.dtos.article.dashboard.ArticleUpdateDto;
import az.edu.itbrains.bloggg130.dtos.category.CategoryCreateDto;
import az.edu.itbrains.bloggg130.dtos.category.CategoryDashboardDto;
import az.edu.itbrains.bloggg130.dtos.category.CategoryUpdateDto;
import az.edu.itbrains.bloggg130.response.PaginationResponse;

import java.util.List;

public interface ArticleService {
    List<ArticleBannerDto> getBannerArticles();
    PaginationResponse<ArticleFeedDto> getFeedArticles(Integer pageNumber);

    ArticleDetailDto getArticleDetail(Long id);

    PaginationResponse<ArticleCategoryDto> getArticlesByCategoryId(Integer pageNumber,Long categoryId);


    List<ArticleRelatedDto> getRelatedArticles(Long id, Long categoryId);
    List<ArticleDashboardDto> getDashboardArticles();

    ArticleUpdateDto getUpdateArticle(Long id);

    void updateArticle(Long id, ArticleUpdateDto articleUpdateDto);
    void createArticle(ArticleCreateDto articleCreateDto);
    void deleteArticle(Long id);

}

package az.edu.itbrains.bloggg130.controllers;

import az.edu.itbrains.bloggg130.dtos.article.ArticleCategoryDto;
import az.edu.itbrains.bloggg130.dtos.article.ArticleDetailDto;
import az.edu.itbrains.bloggg130.dtos.article.ArticleRelatedDto;
import az.edu.itbrains.bloggg130.dtos.category.CategoryPopularDto;
import az.edu.itbrains.bloggg130.response.PaginationResponse;
import az.edu.itbrains.bloggg130.services.ArticleService;
import az.edu.itbrains.bloggg130.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final CategoryService categoryService;

    @GetMapping("/article/detail/{id}")
    public String detail(@PathVariable Long id, Model model){
        ArticleDetailDto articleDetailDto=articleService.getArticleDetail(id);
        List<ArticleRelatedDto> articleRelatedDtoList=articleService.getRelatedArticles(id,articleDetailDto.getCategory().getId());
        List<CategoryPopularDto> categoryPopularDtoList=categoryService.getPopularCategories();


        model.addAttribute("article",articleDetailDto);
        model.addAttribute("articleRelated",articleRelatedDtoList);
        model.addAttribute("popularCategories",categoryPopularDtoList);
        return "article/detail.html";

    }
    @GetMapping("/article/category/{categoryId}")
    public String articleCategory(@PathVariable Long categoryId, Model model,Integer pageNumber){
        PaginationResponse<ArticleCategoryDto> articleDetailDto=articleService.getArticlesByCategoryId(pageNumber,categoryId);


        model.addAttribute("articles",articleDetailDto.getData());
        model.addAttribute("pageSize",articleDetailDto.getPageSize());
        return "article/category.html";

    }
}

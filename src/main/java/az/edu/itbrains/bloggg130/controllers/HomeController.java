package az.edu.itbrains.bloggg130.controllers;

import az.edu.itbrains.bloggg130.dtos.article.ArticleBannerDto;
import az.edu.itbrains.bloggg130.dtos.article.ArticleFeedDto;
import az.edu.itbrains.bloggg130.dtos.category.CategoryNavbarDto;
import az.edu.itbrains.bloggg130.models.Article;
import az.edu.itbrains.bloggg130.repositories.ArticleRepository;
import az.edu.itbrains.bloggg130.response.PaginationResponse;
import az.edu.itbrains.bloggg130.services.ArticleService;
import az.edu.itbrains.bloggg130.services.CategoryService;
import az.edu.itbrains.bloggg130.services.Impls.ArticleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {


    private final ArticleService articleService;
    private final CategoryService categoryService;

    @GetMapping("/")
    public String index(Model model,Integer pageNumber) {
        List<ArticleBannerDto> bannerDtoList=articleService.getBannerArticles();
        PaginationResponse<ArticleFeedDto> articleFeedDtoList=articleService.getFeedArticles(pageNumber);


        model.addAttribute("articles",bannerDtoList);
        model.addAttribute("articleFeed",articleFeedDtoList.getData());
        model.addAttribute("pageSize",articleFeedDtoList.getPageSize());
        return "index.html";

    }

    @GetMapping("/contact")
    public String contact() {
        return "contact.html";

    }
    @GetMapping("/category")
    public String category() {
        return "category.html";

    }
    @GetMapping("/single")
    public String single() {
        return "single.html";

    }

}


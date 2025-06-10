package az.edu.itbrains.bloggg130.controllers.dashboard;


import az.edu.itbrains.bloggg130.dtos.article.dashboard.ArticleCreateDto;
import az.edu.itbrains.bloggg130.dtos.article.dashboard.ArticleDashboardDto;
import az.edu.itbrains.bloggg130.dtos.article.dashboard.ArticleUpdateDto;
import az.edu.itbrains.bloggg130.dtos.category.CategoryDashboardDto;
import az.edu.itbrains.bloggg130.dtos.category.CategoryDto;
import az.edu.itbrains.bloggg130.services.ArticleService;
import az.edu.itbrains.bloggg130.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class ArticlesController {
    private final ArticleService articleService;
    private final CategoryService categoryService;

    @GetMapping("/dashboard/article")
    public String index(Model model){
        List<ArticleDashboardDto> articleDashboardDtoList=articleService.getDashboardArticles();
        model.addAttribute("articles",articleDashboardDtoList);
        return "/dashboard/article/index.html";
    }

    @GetMapping("/dashboard/article/create")
    public String create(Model model){
        List<CategoryDashboardDto> categoryDtoList=categoryService.getDashboardCategories();
        model.addAttribute("categories",categoryDtoList);
        return "/dashboard/article/create.html";
    }

    @PostMapping("/dashboard/article/create")
    public String create(ArticleCreateDto articleCreateDto){
        articleService.createArticle(articleCreateDto);
        return "redirect:/dashboard/article";
    }
    @GetMapping("/dashboard/article/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        ArticleUpdateDto articleUpdateDto=articleService.getUpdateArticle(id);
        List<CategoryDashboardDto> categoryDtoList=categoryService.getDashboardCategories();
        model.addAttribute("categories",categoryDtoList);
        model.addAttribute("article",articleUpdateDto);
        return "/dashboard/article/update.html";
    }
    @PostMapping("/dashboard/article/edit/{id}")
    public String edit(@PathVariable Long id, ArticleUpdateDto articleUpdateDto){
        articleService.updateArticle(id,articleUpdateDto);
        return "redirect:/dashboard/article";
    }


    @GetMapping("/dashboard/article/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        return  "/dashboard/article/delete.html";
    }
    @PostMapping("/dashboard/article/delete/{id}")
    public String mdelete(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        return "redirect:/dashboard/article";
    }
}

package az.edu.itbrains.bloggg130.controllers.dashboard;

import az.edu.itbrains.bloggg130.dtos.category.CategoryCreateDto;
import az.edu.itbrains.bloggg130.dtos.category.CategoryDashboardDto;
import az.edu.itbrains.bloggg130.dtos.category.CategoryUpdateDto;
import az.edu.itbrains.bloggg130.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/dashboard/category")
    public String index(Model model){
        List<CategoryDashboardDto> categoryDashboardDtoList=categoryService.getDashboardCategories();
        model.addAttribute("categories",categoryDashboardDtoList);
        return "/dashboard/category/index.html";
    }

    @GetMapping("/dashboard/category/create")
    public String create(){

        return "/dashboard/category/create.html";
    }

    @PostMapping("/dashboard/category/create")
    public String create(CategoryCreateDto categoryCreateDto){
        categoryService.createCategory(categoryCreateDto);
        return "redirect:/dashboard/category";
    }

    @GetMapping("/dashboard/category/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        CategoryUpdateDto categoryUpdateDto=categoryService.getUpdateCategory(id);
        model.addAttribute("category",categoryUpdateDto);
        return "/dashboard/category/update.html";
    }
    @PostMapping("/dashboard/category/edit/{id}")
    public String edit(@PathVariable Long id, CategoryUpdateDto categoryUpdateDto){
     categoryService.updateCategory(id,categoryUpdateDto);
        return "redirect:/dashboard/category";
    }
    @GetMapping("/dashboard/category/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        return  "/dashboard/category/delete.html";
    }
    @PostMapping("/dashboard/category/delete/{id}")
    public String mdelete(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/dashboard/category";
    }
}

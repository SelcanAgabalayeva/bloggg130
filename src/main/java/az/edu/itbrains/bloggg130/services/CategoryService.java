package az.edu.itbrains.bloggg130.services;

import az.edu.itbrains.bloggg130.dtos.category.*;
import az.edu.itbrains.bloggg130.models.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryPopularDto> getPopularCategories();
    List<CategoryNavbarDto> getNavbarCategories();

    List<CategoryDashboardDto> getDashboardCategories();

    CategoryUpdateDto getUpdateCategory(Long id);

    void updateCategory(Long id, CategoryUpdateDto categoryUpdateDto);
    void createCategory(CategoryCreateDto categoryCreateDto);
    Category getCategoryById(Long categoryId);
    void deleteCategory(Long id);

}

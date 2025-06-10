package az.edu.itbrains.bloggg130.services.Impls;

import az.edu.itbrains.bloggg130.dtos.category.*;
import az.edu.itbrains.bloggg130.models.Category;
import az.edu.itbrains.bloggg130.repositories.CategoryRepository;
import az.edu.itbrains.bloggg130.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private  CategoryRepository categoryRepository;
    @Autowired
    private  ModelMapper modelMapper;

    @Override
    public List<CategoryPopularDto> getPopularCategories() {
        List<Category> categoryList=categoryRepository.findAll().stream().limit(5).collect(Collectors.toList());
        List<CategoryPopularDto> categoryPopularDtoList=categoryList.stream().map(c->modelMapper.map(c, CategoryPopularDto.class)).collect(Collectors.toList());

        return categoryPopularDtoList;
    }

    @Override
    public List<CategoryNavbarDto> getNavbarCategories() {
        List<Category> categoryList=categoryRepository.findByIsNavbarTrue();
        List<CategoryNavbarDto> categoryNavbarDtoList=categoryList.stream().map(category -> modelMapper.map(category, CategoryNavbarDto.class)).collect(Collectors.toList());

        return categoryNavbarDtoList;
    }

    @Override
    public List<CategoryDashboardDto> getDashboardCategories() {
        List<Category> categoryList=categoryRepository.findAll();
        List<CategoryDashboardDto> categoryDashboardDtoList=categoryList.stream().map(x->modelMapper.map(x, CategoryDashboardDto.class)).collect(Collectors.toList());
        return categoryDashboardDtoList;
    }

    @Override
    public CategoryUpdateDto getUpdateCategory(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow();
        CategoryUpdateDto categoryUpdateDto=modelMapper.map(category,CategoryUpdateDto.class);
        return categoryUpdateDto;
    }

    @Override
    public void updateCategory(Long id, CategoryUpdateDto categoryUpdateDto) {
        Category category=categoryRepository.findById(id).orElseThrow();
        category.setName(categoryUpdateDto.getName());
        categoryRepository.save(category);

    }

    @Override
    public void createCategory(CategoryCreateDto categoryCreateDto) {
        Category category = new Category();
        category.setName(categoryCreateDto.getName());
        categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow();
    }

    @Override
    public void deleteCategory(Long id) {
        Category findCategory=categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(findCategory);
    }

}





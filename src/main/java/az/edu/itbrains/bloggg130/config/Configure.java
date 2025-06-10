package az.edu.itbrains.bloggg130.config;

import az.edu.itbrains.bloggg130.services.CategoryService;
import az.edu.itbrains.bloggg130.services.Impls.CategoryServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configure {
    @Bean
    public ModelMapper modelMapper(){
    return new ModelMapper();


}

    @Bean
    public CategoryService categoryService(){
        return new CategoryServiceImpl();
    }

}

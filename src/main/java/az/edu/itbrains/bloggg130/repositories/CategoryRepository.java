package az.edu.itbrains.bloggg130.repositories;

import az.edu.itbrains.bloggg130.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findByIsNavbarTrue();

}

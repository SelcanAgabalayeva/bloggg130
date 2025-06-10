package az.edu.itbrains.bloggg130.repositories;

import az.edu.itbrains.bloggg130.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}

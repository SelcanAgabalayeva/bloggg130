package az.edu.itbrains.bloggg130.services;

import az.edu.itbrains.bloggg130.dtos.auth.RegisterDto;
import az.edu.itbrains.bloggg130.models.User;

public interface UserService {
    boolean registerUser(RegisterDto registerDto);
    User findUser(String email);
}

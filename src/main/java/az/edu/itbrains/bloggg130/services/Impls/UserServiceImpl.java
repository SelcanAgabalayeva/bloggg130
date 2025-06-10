package az.edu.itbrains.bloggg130.services.Impls;

import az.edu.itbrains.bloggg130.dtos.auth.RegisterDto;
import az.edu.itbrains.bloggg130.models.User;
import az.edu.itbrains.bloggg130.repositories.UserRepository;
import az.edu.itbrains.bloggg130.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public boolean registerUser(RegisterDto registerDto) {
        User findUser=userRepository.findByEmail(registerDto.getEmail());
        if(findUser !=null){
            return false;
        }

        User user=new User();
        user.setEmail(registerDto.getEmail());
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        String password=passwordEncoder.encode(registerDto.getPassword());
        user.setPassword(password);
        userRepository.save(user);
        return true;
    }

    @Override
    public User findUser(String email) {
        return userRepository.findByEmail(email);
    }
}

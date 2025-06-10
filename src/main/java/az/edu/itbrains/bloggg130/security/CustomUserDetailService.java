package az.edu.itbrains.bloggg130.security;

import az.edu.itbrains.bloggg130.models.User;
import az.edu.itbrains.bloggg130.repositories.UserRepository;
import az.edu.itbrains.bloggg130.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;
@Configuration
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User findUser=userRepository.findByEmail(username);
            org.springframework.security.core.userdetails.User user=new org.springframework.security.core.userdetails.User(
                    findUser.getEmail(),
                    findUser.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    findUser.getRoles().stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
            );
            return user;
        }catch (Exception e){
            throw new UsernameNotFoundException(e.getMessage());

        }

    }
}

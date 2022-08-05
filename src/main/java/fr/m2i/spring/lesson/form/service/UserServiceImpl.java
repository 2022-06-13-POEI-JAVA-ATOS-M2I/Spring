package fr.m2i.spring.lesson.form.service;

import fr.m2i.spring.lesson.form.model.Role;
import fr.m2i.spring.lesson.form.model.User;
import fr.m2i.spring.lesson.form.repository.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    
    
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        
        User adminUser = new User("admin", "admin", "admin@mail.com", "admin");
        
        adminUser.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
        adminUser.setPassword(passwordEncoder.encode(adminUser.getPassword()));
        
        userRepository.save(adminUser);
    }
    
    
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }      
        
        return user;
    }
   
}

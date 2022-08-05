package fr.m2i.spring.lesson.form.service;

import fr.m2i.spring.lesson.form.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    User findByEmail(String email);

    User save(User user);
}
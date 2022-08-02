package fr.m2i.spring.lesson.mvc.config;

import fr.m2i.spring.lesson.mvc.model.Role;
import fr.m2i.spring.lesson.mvc.model.User;
import fr.m2i.spring.lesson.mvc.repository.RoleRepository;
import fr.m2i.spring.lesson.mvc.service.IUserService;
import java.util.Arrays;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OnApplicationStartup implements InitializingBean {

    private final IUserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public OnApplicationStartup(IUserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Role roleAdmin = new Role("ADMIN");
        Role roleProvider = new Role("PROVIDER");
        Role roleCustomer = new Role("CUSTOMER");

        roleRepository.saveAll(Arrays.asList(roleAdmin, roleProvider, roleCustomer));

        User admin = new User("admin", "admin", "admin@admin.com", "admin", new Role(1L));

        userService.save(admin);
    }
}

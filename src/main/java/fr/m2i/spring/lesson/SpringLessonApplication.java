package fr.m2i.spring.lesson;

import fr.m2i.spring.lesson.config.DatasourceConfig;
import fr.m2i.spring.lesson.service.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// Equivalent de
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan
@SpringBootApplication
public class SpringLessonApplication {

    public static void main(String args[]) {
        ApplicationContext ctx = SpringApplication.run(SpringLessonApplication.class, args);
        
        AccountService accountService = ctx.getBean(AccountService.class);
        accountService.findOldestClient().ifPresent(System.out::println);
    }
}

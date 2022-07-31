package fr.m2i.spring.lesson;

import fr.m2i.spring.lesson.config.DatasourceConfig;
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
        
        DatasourceConfig ds = ctx.getBean(DatasourceConfig.class);
        ds.setup();
    }
}

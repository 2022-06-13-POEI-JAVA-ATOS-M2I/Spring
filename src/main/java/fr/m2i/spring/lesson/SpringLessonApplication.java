package fr.m2i.spring.lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Equivalent de
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan
@SpringBootApplication
public class SpringLessonApplication {

    public static void main(String args[]) {
        SpringApplication.run(SpringLessonApplication.class, args);
    }
}

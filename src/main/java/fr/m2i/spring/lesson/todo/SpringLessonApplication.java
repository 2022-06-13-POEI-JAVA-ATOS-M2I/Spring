package fr.m2i.spring.lesson.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class SpringLessonApplication
{
	
	public static void main(String[] args)
	{
		SpringApplication.run(SpringLessonApplication.class);
	}
}
package fr.m2i.spring.lesson.todo.repository;


import fr.m2i.spring.lesson.todo.model.Todo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Long>{
	List<Todo> findByUserName(String user);
}
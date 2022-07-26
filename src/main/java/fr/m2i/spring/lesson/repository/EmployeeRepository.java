package fr.m2i.spring.lesson.repository;

import fr.m2i.spring.lesson.model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

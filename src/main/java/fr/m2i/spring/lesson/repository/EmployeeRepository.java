package fr.m2i.spring.lesson.repository;

import fr.m2i.spring.lesson.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByFirstName(String firstname);

    @Query("SELECT e FROM Employee e WHERE LOWER(e.lastName) = LOWER(:lastname)")
    Employee retrieveByLastName(@Param("lastname") String lastname);
}

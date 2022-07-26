package fr.m2i.spring.lesson.controller;

import fr.m2i.spring.lesson.model.Employee;
import fr.m2i.spring.lesson.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/employees")
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }
}

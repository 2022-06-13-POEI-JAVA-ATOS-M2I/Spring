package fr.m2i.spring.lesson.controller;

import fr.m2i.spring.lesson.model.Employee;
import fr.m2i.spring.lesson.service.EmployeeService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @GetMapping("/employees")
    public List<Employee> getEmployeeList() {
        return employeeService.findAll();
    }

//    @ResponseBody
//    @GetMapping("/employees/{firstname}")
//    public Employee getEmployeeByFirstName(@PathVariable("firstname") String firstname) {
//        return employeeService.findByFirstName(firstname);
//    }

    @ResponseBody
    @GetMapping("/employees/{lastname}")
    public Employee getEmployeeByLastName(@PathVariable("lastname") String lastname) {
        return employeeService.findByLastName(lastname);
    }

    @ResponseBody
    @PostMapping(path = "/employees", consumes = "application/json")
    public Employee create(@RequestBody Employee employee) throws SQLException {
        employeeService.create(employee);
        return employee;
    }
}

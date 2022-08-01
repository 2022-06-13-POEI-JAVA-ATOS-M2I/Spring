package fr.m2i.spring.lesson.service;

import fr.m2i.spring.lesson.model.Employee;
import fr.m2i.spring.lesson.repository.EmployeeRepository;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findByFirstName(String firstname) {
        return employeeRepository.findByFirstName(firstname);
    }

    public Employee findByLastName(String lastname) {
        return employeeRepository.retrieveByLastName(lastname);
    }

    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

//    @Transactional
//    public void create(Employee employee) {
//        employeeRepository.save(employee);
//        throw new DataIntegrityViolationException("Rollback example");
//    }

//    @Transactional(noRollbackFor = {SQLException.class})
//    public void create(Employee employee) throws SQLException {
//        employeeRepository.save(employee);
//        throw new SQLException("Rollback example for SQL exception");
//    }
//    @Transactional(noRollbackFor = {SQLException.class})
//    public void create(Employee employee) throws SQLException {
//        employeeRepository.save(employee);
//        throw new SQLException("No rollback example");
//    }

//    @Transactional
//    public void create(Employee employee) {
//        try {
//            employeeRepository.save(employee);
//            int i = 1/0;
//        } catch (Exception e) {
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        }
//    }

}

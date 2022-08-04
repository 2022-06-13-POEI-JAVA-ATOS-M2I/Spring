package fr.m2i.apifilrougecrm.service;

import fr.m2i.apifilrougecrm.dto.CustomerMapper;
import fr.m2i.apifilrougecrm.entity.Customer;
import fr.m2i.apifilrougecrm.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import fr.m2i.apifilrougecrm.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void update(Customer content){

        Customer toUpdate = findById(content.getId());
        toUpdate = CustomerMapper.copy(toUpdate, content);

        customerRepository.save(toUpdate);
    }

    public void delete(Long id) {
        Customer toDelete = findById(id);
        customerRepository.delete(toDelete);
    }

}

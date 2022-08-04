package fr.m2i.apifilrougecrm.controller;

import fr.m2i.apifilrougecrm.dto.CustomerDTO;
import fr.m2i.apifilrougecrm.dto.CustomerMapper;
import fr.m2i.apifilrougecrm.entity.Customer;
import fr.m2i.apifilrougecrm.exception.NotFoundException;
import fr.m2i.apifilrougecrm.response.CrmResponseEntity;
import fr.m2i.apifilrougecrm.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns the list of all customers", nickname = "Get all customers", response = CustomerDTO.class)
    public ResponseEntity<List<CustomerDTO>> getAll() {

        List<Customer> customers = customerService.findAll();
        List<CustomerDTO> customersDto = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO customerDto = CustomerMapper.buildCustomerDTO(customer);
            customersDto.add(customerDto);
        }

        return ResponseEntity.ok(customersDto);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Return a customer", nickname = "Get a customer by Id", response = CustomerDTO.class)
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) {
        try {
            Customer customer = customerService.findById(id);
            CustomerDTO customerDTO = CustomerMapper.buildCustomerDTO(customer);
            return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
        } catch (NotFoundException e) {
            return CrmResponseEntity.build("Customer not found", 404, "/v1/customers/" + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return CrmResponseEntity.build(e.getMessage(), 500, "/v1/orders/", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Create customer", nickname = "Create customer", code = 201)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody CustomerDTO customerDTO) {

        try {
            Customer toCreate = CustomerMapper.buildCustomer(customerDTO);
            Customer created = customerService.create(toCreate);
            CustomerDTO createdDto = CustomerMapper.buildCustomerDTO(created);

            return ResponseEntity.created(URI.create("/v1/customers")).body(createdDto);
        } catch (Exception e) {
            return CrmResponseEntity.build(e.getMessage(), 500, "/v1/orders/", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Update customer", nickname = "Update customer", code = 204)
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody CustomerDTO customerDto) {

        customerDto.setId(id);
        Customer customer = CustomerMapper.buildCustomer(customerDto);

        try {
            customerService.update(customer);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return CrmResponseEntity.build("Customer not found", 404, "/v1/customers/" + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return CrmResponseEntity.build(e.getMessage(), 500, "/v1/orders/", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete customer", nickname = "Delete customer", code = 204)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        try {
            customerService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return CrmResponseEntity.build("Customer not found", 404, "/v1/customers/" + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return CrmResponseEntity.build(e.getMessage(), 500, "/v1/orders/", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

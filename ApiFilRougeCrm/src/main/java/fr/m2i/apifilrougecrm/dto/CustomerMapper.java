package fr.m2i.apifilrougecrm.dto;

import fr.m2i.apifilrougecrm.entity.Customer;

public class CustomerMapper {

    public static CustomerDTO buildCustomerDTO(Customer customer) {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setCompanyName(customer.getCompanyName());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setZipCode(customer.getZipCode());
        customerDTO.setCity(customer.getCity());
        customerDTO.setCountry(customer.getCountry());

        switch (customer.getState()){
            case 0:
                customerDTO.setState("INACTIVE");
                break;
            case 1:
                customerDTO.setState("ACTIVE");
                break;
            default:
                customerDTO.setState("");
        }

        return customerDTO;
    }

    public static Customer buildCustomer(CustomerDTO customerDTO){

        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setCompanyName(customerDTO.getCompanyName());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setAddress(customerDTO.getAddress());
        customer.setZipCode(customerDTO.getZipCode());
        customer.setCity(customerDTO.getCity());
        customer.setCountry(customerDTO.getCountry());

        switch (customerDTO.getState()){
            case "INACTIVE":
                customer.setState(0);
                break;
            case "ACTIVE":
                customer.setState(1);
                break;
            default:
                customer.setState(0);
        }

        return customer;
    }

    public static Customer copy(Customer customer, Customer content){

        if (content.getCompanyName() != null) {
            customer.setCompanyName(content.getCompanyName());
        }
        
        if (content.getFirstName() != null) {
            customer.setFirstName(content.getFirstName());
        }
        
        if (content.getLastName() != null) {
            customer.setLastName(content.getLastName());
        }
        
        if (content.getEmail() != null) {
            customer.setEmail(content.getEmail());
        }
        
        if (content.getPhone() != null) {
            customer.setPhone(content.getPhone());
        }
        
        if (content.getAddress() != null) {
            customer.setAddress(content.getAddress());
        }
        
        if (content.getZipCode() != null) {
            customer.setZipCode(content.getZipCode());
        }
        
        if (content.getCity() != null) {
            customer.setCity(content.getCity());
        }
        
        if (content.getCountry() != null) {
            customer.setCountry(content.getCountry());
        }
        
        if (content.getState() != -1) {
            customer.setState(content.getState());
        }

        return customer;
    }
}

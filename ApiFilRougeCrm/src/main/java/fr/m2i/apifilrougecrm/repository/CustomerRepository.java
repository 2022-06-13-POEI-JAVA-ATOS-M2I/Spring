package fr.m2i.apifilrougecrm.repository;

import fr.m2i.apifilrougecrm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

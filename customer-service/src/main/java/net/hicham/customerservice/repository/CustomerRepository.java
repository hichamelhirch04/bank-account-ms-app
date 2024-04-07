package net.hicham.customerservice.repository;

import net.hicham.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

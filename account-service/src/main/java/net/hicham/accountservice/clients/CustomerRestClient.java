package net.hicham.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.hicham.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")

    Customer findCustomerById( @PathVariable  Long id);
    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultAllCustomers")
    List<Customer> allCustomers();
    default Customer getDefaultCustomer(Long id,Exception exception){
        Customer customer=new Customer();
        customer.setId(id);
        customer.setFirstName("not vailable");
        customer.setLastName("not vailable");
        customer.setEmail("not vailable");
        return customer;
    }
    default List<Customer> getDefaultAllCustomers(Exception exception){
        return List.of();
    }
}

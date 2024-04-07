package net.hicham.accountservice.web;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.hicham.accountservice.clients.CustomerRestClient;
import net.hicham.accountservice.entiies.BankAccount;
import net.hicham.accountservice.model.Customer;
import net.hicham.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class BankAccountRestController {
   private BankAccountRepository bankAccountRepository;
   private CustomerRestClient customerRestClient;


    public BankAccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }
    @GetMapping("/accounts")
    public List<BankAccount> bankAccountList(){

       List<BankAccount> bankAccountList= bankAccountRepository.findAll();
       bankAccountList.forEach(acc->{
           acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));

       });
        return bankAccountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountList(@PathVariable String id){
      BankAccount bankAccount=bankAccountRepository.findById(id).orElse(null);
        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}

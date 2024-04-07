package net.hicham.accountservice;

import net.hicham.accountservice.clients.CustomerRestClient;
import net.hicham.accountservice.entiies.BankAccount;
import net.hicham.accountservice.enums.Accounttype;
import net.hicham.accountservice.repository.BankAccountRepository;
import org.aspectj.bridge.ICommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
  @Bean
   CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository , CustomerRestClient customerRestClient){
       return args -> {
           customerRestClient.allCustomers().forEach(c -> {
               BankAccount bankAccount1=BankAccount.builder()
                       .accountId(UUID.randomUUID().toString())
                       .balance(123.5)
                       .createdAt(LocalDate.now())
                       .currency("DH")
                       .customerId(c.getId())
                       .type(Accounttype.SAVING_ACCOUNT)

                       .build();
               BankAccount bankAccount2=BankAccount.builder()
                       .accountId(UUID.randomUUID().toString())
                       .balance(8888)
                       .createdAt(LocalDate.now())
                       .currency("$")
                       .customerId(c.getId())
                       .type(Accounttype.CURRENT_ACCOUNT)
                       .build();
               bankAccountRepository.save(bankAccount1);
               bankAccountRepository.save(bankAccount2);

               System.out.println("##########################");
               System.out.println(bankAccount1.getBalance());
               System.out.println("##########################");
           });

       } ;

   }
}

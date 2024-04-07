package net.hicham.customerservice;

import net.hicham.customerservice.Config.GlobalConfig;
import net.hicham.customerservice.entities.Customer;
import net.hicham.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
  @Bean
   CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
          List<Customer> customerList=List.of(Customer.builder()
				  .firstName("hicham")
				  .lastName("elhirch")
				  .email("hichamelhirch@gmai.com")

				  .build(),

				  Customer.builder()
						  .firstName("rachid")
						  .lastName("elhirch")
						  .email("rachidelhirch@gmai.com")

						  .build()

				  );
		  customerRepository.saveAll(customerList);
		};
   }
}

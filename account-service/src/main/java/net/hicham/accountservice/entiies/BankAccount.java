package net.hicham.accountservice.entiies;

import jakarta.persistence.*;
import lombok.*;
import net.hicham.accountservice.enums.Accounttype;
import net.hicham.accountservice.model.Customer;

import java.time.LocalDate;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private String currency;
    private LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    private Accounttype type;
    @Transient
    private Customer customer;
    private Long customerId;

}

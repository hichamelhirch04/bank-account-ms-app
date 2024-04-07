package net.hicham.accountservice.repository;

import net.hicham.accountservice.entiies.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}

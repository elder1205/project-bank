package ec.com.sofka.repository;

import ec.com.sofka.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository  extends JpaRepository<AccountEntity, String> {
    AccountEntity findByAccountNumber(String  accountNumber);
}

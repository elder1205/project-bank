package ec.com.sofka.usecases.accounts;

import ec.com.sofka.Account;
import ec.com.sofka.gateway.AccountRepository;

public class CreateAccountUseCase {
    private final AccountRepository accountRepository;

    public CreateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(Account account){
        return accountRepository.saveAccount(account);
    }

}

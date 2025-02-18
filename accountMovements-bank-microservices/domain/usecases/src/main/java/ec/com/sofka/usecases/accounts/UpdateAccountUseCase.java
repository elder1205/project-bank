package ec.com.sofka.usecases.accounts;

import ec.com.sofka.Account;
import ec.com.sofka.gateway.AccountRepository;

public class UpdateAccountUseCase {
    private final AccountRepository accountRepository;

    public UpdateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(Account account) {
        return accountRepository.updateAccount(account);
    }
}

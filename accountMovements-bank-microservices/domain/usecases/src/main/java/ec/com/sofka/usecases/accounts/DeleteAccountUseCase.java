package ec.com.sofka.usecases.accounts;

import ec.com.sofka.gateway.AccountRepository;

public class DeleteAccountUseCase {
    private final AccountRepository accountRepository;

    public DeleteAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(String id) {
        accountRepository.deleteAccount(id);
    }

}

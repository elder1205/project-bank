package ec.com.sofka.usecases.accounts;

import ec.com.sofka.Account;
import ec.com.sofka.gateway.AccountRepository;

import java.util.List;

public class GetAllAccountsUseCase {
    private final AccountRepository accountRepository;

    public GetAllAccountsUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> execute(){
        List<Account> accounts = accountRepository.listAccount();
        if(accounts.isEmpty()){
            throw new RuntimeException("No accounts found");
        }
        return accounts;
    }

}

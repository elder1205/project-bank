package ec.com.sofka.usecases.accounts;

import ec.com.sofka.Account;
import ec.com.sofka.gateway.AccountRepository;

public class GetAccountByIdUseCase {
    private final AccountRepository accountRepository;

    public GetAccountByIdUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(String id){
       return  accountRepository.findAccountById(id);
    }

}

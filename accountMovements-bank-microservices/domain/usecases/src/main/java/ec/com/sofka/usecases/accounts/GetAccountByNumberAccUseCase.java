package ec.com.sofka.usecases.accounts;

import ec.com.sofka.Account;
import ec.com.sofka.gateway.AccountRepository;

public class GetAccountByNumberAccUseCase {
    private final AccountRepository accountRepository;

    public GetAccountByNumberAccUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public Account execute(String numberAcc){
        Account account = accountRepository.findAccountByAccountNumber(numberAcc);
        if(account == null){
            throw new RuntimeException("Account  with "+numberAcc +" not found");
        }
        return account;
    }
}

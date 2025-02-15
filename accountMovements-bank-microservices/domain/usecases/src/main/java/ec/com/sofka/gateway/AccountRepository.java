package ec.com.sofka.gateway;

import ec.com.sofka.Account;

import java.util.List;

public interface AccountRepository {
    Account saveAccount(Account account);
    Account updateAccount(Account account);
    List<Account> listAccount();
    Account findAccountById(String id);
    Void deleteAccount(String id);

}

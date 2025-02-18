package ec.com.sofka.mappers;
import ec.com.sofka.Account;
import ec.com.sofka.entities.AccountEntity;

public class AccountMapper {
    public static Account toModel(AccountEntity accountEntity){
        if (accountEntity == null) {
            return null;
        }
        Account account = new Account();
        account.setIdAccount(accountEntity.getIdAccount());
        account.setAccountNumber(accountEntity.getAccountNumber());
        account.setTypeAccount(accountEntity.getTypeAccount());
        account.setOpeningBalance(accountEntity.getOpeningBalance());
        account.setState(accountEntity.getState());
        account.setIdClient(accountEntity.getIdClient());
        return account;

    }

    public static AccountEntity toEntity(Account account){
        if (account == null) {
            return null;
        }
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setIdAccount(account.getIdAccount());
        accountEntity.setAccountNumber(account.getAccountNumber());
        accountEntity.setTypeAccount(account.getTypeAccount());
        accountEntity.setOpeningBalance(account.getOpeningBalance());
        accountEntity.setState(account.getState());
        accountEntity.setIdClient(account.getIdClient());
        return accountEntity;

    }
}

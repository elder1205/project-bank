package ec.com.sofka.adapter;

import ec.com.sofka.Account;
import ec.com.sofka.entities.AccountEntity;
import ec.com.sofka.gateway.AccountRepository;
import ec.com.sofka.mappers.AccountMapper;
import ec.com.sofka.repository.IAccountRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MySQLAdapterAccount  implements AccountRepository {
    private final IAccountRepository accountRepository;

    public MySQLAdapterAccount(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account saveAccount(Account account) {
        AccountEntity accountEntity = accountRepository.save(AccountMapper.toEntity(account));
        return AccountMapper.toModel(accountEntity);
    }

    @Override
    public Account updateAccount(Account account) {
        AccountEntity accountEntity = accountRepository.save(AccountMapper.toEntity(account));
        return AccountMapper.toModel(accountEntity);
    }

    @Override
    public List<Account> listAccount() {
        List<AccountEntity> accountEntities = accountRepository.findAll();
        return accountEntities.stream()
                .map(AccountMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Account findAccountById(String id) {
        AccountEntity accountEntity = accountRepository.findById(id).orElse(null);
        if(accountEntity == null){
            throw new RuntimeException("Account not found");
        }
        return AccountMapper.toModel(accountEntity);
    }

    @Override
    public Void deleteAccount(String id) {
        return null;
    }

    @Override
    public Account findAccountByAccountNumber(String numberAcc) {
        return AccountMapper.toModel(accountRepository.findByAccountNumber(numberAcc));
    }

    @Override
    public Account findByIdClient(String idClient) {
        AccountEntity accountEntity = accountRepository.findByIdClient(idClient);
        if(accountEntity == null){
            throw new RuntimeException("Account not found");
        }
        return AccountMapper.toModel(accountEntity);
    }
}

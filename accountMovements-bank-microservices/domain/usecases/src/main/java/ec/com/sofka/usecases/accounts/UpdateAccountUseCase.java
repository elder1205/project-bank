package ec.com.sofka.usecases.accounts;

import ec.com.sofka.Account;
import ec.com.sofka.data.CustomerInfoRequestRecord;
import ec.com.sofka.exceptions.AccountNotFound;
import ec.com.sofka.exceptions.CustomerNotFound;
import ec.com.sofka.exceptions.NumberAccountNotFoundException;
import ec.com.sofka.gateway.AccountRepository;
import ec.com.sofka.gateway.IBusMessage;

public class UpdateAccountUseCase {
    private final AccountRepository accountRepository;
    private final IBusMessage busMessage;

    public UpdateAccountUseCase(AccountRepository accountRepository, IBusMessage busMessage) {
        this.accountRepository = accountRepository;
        this.busMessage = busMessage;
    }

    public Account execute(Account account, Boolean flag) {
        if(!flag){
            return accountRepository.updateAccount(account);
        }
        if (accountRepository.findAccountByAccountNumber(account.getAccountNumber()) == null) {
            Account accountTemp = accountRepository.findAccountById(account.getIdAccount());
            Object response;
            String customerId;
            response = busMessage.sendMessage(new CustomerInfoRequestRecord(account.getIdClient(), false));
            customerId = (String) response;

            if (customerId == null || customerId.isEmpty()) {
                throw new CustomerNotFound("Error updated account: Customer not Found");
            }
            account.setIdClient(customerId);
           // return accountRepository.saveAccount(account);
            Account accountUpdated = accountRepository.updateAccount(account);
            if (accountUpdated == null) {
                throw new RuntimeException("Account not updated");
            }
            return accountUpdated;
        }
        throw new NumberAccountNotFoundException("Number account already exists");
    }
}
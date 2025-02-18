package ec.com.sofka.usecases.accounts;

import ec.com.sofka.Account;
import ec.com.sofka.data.CustomerInfoRequestRecord;
import ec.com.sofka.gateway.AccountRepository;
import ec.com.sofka.gateway.IBusMessage;

public class CreateAccountUseCase {
    private final AccountRepository accountRepository;
    private final IBusMessage busMessage;

    public CreateAccountUseCase(AccountRepository accountRepository, IBusMessage busMessage) {
        this.accountRepository = accountRepository;
        this.busMessage = busMessage;
    }

    public Account execute(Account account, String identification) {
        if (accountRepository.findAccountByAccountNumber(account.getAccountNumber()) == null) {
            Object response;
            String customerId;
            response = busMessage.sendMessage(new CustomerInfoRequestRecord(identification, false));
            customerId = (String) response;

            if (customerId == null || customerId.isEmpty()) {
                throw new RuntimeException("Error creating account: Customer not Found");
            }
            account.setIdClient(customerId);
            return accountRepository.saveAccount(account);
        }
        throw new RuntimeException("Number account already exists");
    }
}

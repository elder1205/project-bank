package ec.com.sofka.usecases.accounts;

import ec.com.sofka.Account;
import ec.com.sofka.data.AccountStatementInfo;
import ec.com.sofka.data.CustomerInfoRecord;
import ec.com.sofka.data.CustomerInfoRequestRecord;
import ec.com.sofka.gateway.AccountRepository;
import ec.com.sofka.gateway.IBusMessage;
import ec.com.sofka.gateway.MovementRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GetAccountStatementUseCase {
    private final AccountRepository accountRepository;
    private final MovementRepository movementRepository;
    private final IBusMessage busMessage;

    public GetAccountStatementUseCase(AccountRepository accountRepository, MovementRepository movementRepository, IBusMessage busMessage) {
        this.accountRepository = accountRepository;
        this.movementRepository = movementRepository;
        this.busMessage = busMessage;
    }

    public List<AccountStatementInfo> execute(String dateRange, String identification) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String[] dates = dateRange.split("-");
        if (dates.length != 2) {
            throw new RuntimeException("Invalid date range format. Use dd/MM/yyyy-dd/MM/yyyy");
        }
        LocalDate startDate = LocalDate.parse(dates[0], formatter);
        LocalDate endDate = LocalDate.parse(dates[1], formatter);
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDatetime = endDate.atTime(23, 59, 59);
        Object response = busMessage.sendMessage(new CustomerInfoRequestRecord(identification, true));
        CustomerInfoRecord info;
        if (response == "") {
            throw new RuntimeException("Error creating account statement: Customer info not Found");
        } else {
            info = (CustomerInfoRecord) response;
        }
        Account account = accountRepository.findByIdClient(info.customerId());
        return movementRepository.findMovementsByDateRangeAndCustomer(startDateTime, endDatetime, account.getIdAccount())
                .stream()
                .map(movement -> new AccountStatementInfo(
                        account.getAccountNumber(),
                        movement.getBalance().subtract(movement.getAmount()),
                        movement.getBalance(),
                        account.getTypeAccount(),
                        info.name(),
                        account.getState(),
                        movement.getAmount(),
                        movement.getDate()
                ))
                .toList();

        //  return List.of();

    }
}

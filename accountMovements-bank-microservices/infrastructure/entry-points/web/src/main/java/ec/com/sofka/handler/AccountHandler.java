package ec.com.sofka.handler;

import ec.com.sofka.Account;
import ec.com.sofka.dto.AccountStatementResponseDTO;
import ec.com.sofka.dto.account.AccountRequestDTO;
import ec.com.sofka.dto.account.AccountResponseDTO;
import ec.com.sofka.mapper.AccountMapper;
import ec.com.sofka.usecases.accounts.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountHandler {
    private final GetAllAccountsUseCase getAllAccountsUseCase;
    private final GetAccountByIdUseCase getAccountByIdUseCase;
    private final CreateAccountUseCase createAccountUseCase;
    private final UpdateAccountUseCase updateAccountUseCase;
    private final GetAccountStatementUseCase getAccountStatementUseCase;

    public AccountHandler(GetAllAccountsUseCase getAllAccountsUseCase, GetAccountByIdUseCase getAccountByIdUseCase, CreateAccountUseCase createAccountUseCase, UpdateAccountUseCase updateAccountUseCase, GetAccountStatementUseCase getAccountStatementUseCase) {
        this.getAllAccountsUseCase = getAllAccountsUseCase;
        this.getAccountByIdUseCase = getAccountByIdUseCase;
        this.createAccountUseCase = createAccountUseCase;
        this.updateAccountUseCase = updateAccountUseCase;
        this.getAccountStatementUseCase = getAccountStatementUseCase;
    }

    public List<AccountResponseDTO> findAll() {
        return getAllAccountsUseCase.execute()
                .stream()
                .map(AccountMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public AccountResponseDTO getAccountById(String id) {
        return AccountMapper.toResponseDTO(getAccountByIdUseCase.execute(id));
    }

    public AccountResponseDTO save(AccountRequestDTO accountRequestDTO) {
        Account account = AccountMapper.toModel(accountRequestDTO);
        return AccountMapper.toResponseDTO(createAccountUseCase.execute(account, account.getIdClient()));
    }

    public AccountResponseDTO update(AccountRequestDTO accountRequestDTO){
        Account account = AccountMapper.toModel(accountRequestDTO);
        return AccountMapper.toResponseDTO(updateAccountUseCase.execute(account,true));
    }

    public List<AccountStatementResponseDTO> getAccountStatements(String dateRange, String customerIdentification) {
        return getAccountStatementUseCase.execute(dateRange, customerIdentification)
                .stream()
                .map(data ->
                        new AccountStatementResponseDTO(
                                data.getAccountNumber(),
                                data.getAccountInitialBalance(),
                                data.getAccountAvailableBalance(),
                                data.getAccountType(),
                                data.getCustomerName(),
                                data.getStatus(),
                                data.getMovementAmount(),
                                data.getDate()
                        )
                )
                .collect(Collectors.toList());
    }

}

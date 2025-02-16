package ec.com.sofka.handler;

import ec.com.sofka.Account;

import ec.com.sofka.dto.account.AccountRequestDTO;
import ec.com.sofka.dto.account.AccountResponseDTO;
import ec.com.sofka.mapper.AccountMapper;
import ec.com.sofka.usecases.accounts.CreateAccountUseCase;
import ec.com.sofka.usecases.accounts.GetAccountByIdUseCase;
import ec.com.sofka.usecases.accounts.GetAllAccountsUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountHandler {
    private final GetAllAccountsUseCase getAllAccountsUseCase;
    private final GetAccountByIdUseCase getAccountByIdUseCase;
    private final CreateAccountUseCase createAccountUseCase;

    public AccountHandler(GetAllAccountsUseCase getAllAccountsUseCase, GetAccountByIdUseCase getAccountByIdUseCase, CreateAccountUseCase createAccountUseCase) {
        this.getAllAccountsUseCase = getAllAccountsUseCase;
        this.getAccountByIdUseCase = getAccountByIdUseCase;
        this.createAccountUseCase = createAccountUseCase;
    }
    public List<AccountResponseDTO> findAll(){
            return getAllAccountsUseCase.execute()
                    .stream()
                    .map(AccountMapper::toResponseDTO)
                    .collect(Collectors.toList());
    }

    public AccountResponseDTO getAccountById(String id){
        return AccountMapper.toResponseDTO(getAccountByIdUseCase.execute(id));
    }

    public AccountResponseDTO save(AccountRequestDTO accountRequestDTO){
        Account account = AccountMapper.toModel(accountRequestDTO);
        return AccountMapper.toResponseDTO(createAccountUseCase.execute(account));
    }

}

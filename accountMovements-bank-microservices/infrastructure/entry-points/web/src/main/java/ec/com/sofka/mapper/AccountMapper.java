package ec.com.sofka.mapper;

import ec.com.sofka.Account;
import ec.com.sofka.dto.account.AccountRequestDTO;
import ec.com.sofka.dto.account.AccountResponseDTO;

public class AccountMapper {
    public static Account toModel(AccountRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        Account account = new Account();
        account.setIdAccount(dto.getIdAccount());
        account.setAccountNumber(dto.getAccountNumber());
        account.setTypeAccount(dto.getTypeAccount());
        account.setOpeningBalance(dto.getOpeningBalance());
        account.setState(dto.getState());
        account.setIdClient(dto.getIdClient());
        return account;
    }

    public static AccountResponseDTO toResponseDTO(Account account) {
        if (account == null) {
            return null;
        }
        AccountResponseDTO responseDTO = new AccountResponseDTO();
        responseDTO.setIdAccount(account.getIdAccount());
        responseDTO.setAccountNumber(account.getAccountNumber());
        responseDTO.setTypeTransaction(account.getTypeAccount());
        responseDTO.setOpeningBalance(account.getOpeningBalance());
        responseDTO.setState(account.getState());
        responseDTO.setIdClient(account.getIdClient());
        return responseDTO;
    }
}

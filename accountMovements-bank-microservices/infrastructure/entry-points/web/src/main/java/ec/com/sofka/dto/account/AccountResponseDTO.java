package ec.com.sofka.dto.account;

import java.math.BigDecimal;

public class AccountResponseDTO {

    private String idAccount;
    private  String accountNumber;
    private String typeTransaction;
    private BigDecimal openingBalance;
    private String state;
    private String idClient;

    public AccountResponseDTO() {
    }

    public AccountResponseDTO(String idAccount, String accountNumber, String typeTransaction, BigDecimal openingBalance, String state, String idClient) {
        this.idAccount = idAccount;
        this.accountNumber = accountNumber;
        this.typeTransaction = typeTransaction;
        this.openingBalance = openingBalance;
        this.state = state;
        this.idClient = idClient;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(BigDecimal openingBalance) {
        this.openingBalance = openingBalance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
}

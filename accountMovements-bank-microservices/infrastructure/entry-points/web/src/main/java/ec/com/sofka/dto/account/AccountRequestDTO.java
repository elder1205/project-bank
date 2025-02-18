package ec.com.sofka.dto.account;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class AccountRequestDTO {
    private String idAccount;
    @NotNull(message = "The accountNumber field must not be null")
    @Size(min = 10, max = 10, message = "The accountNumber field must have exactly 10 digits")
    private String accountNumber;
    @NotBlank(message = "Type account cannot be empty")
    @Pattern(regexp = "Saving|Current", message = "Type account must be Saving, Current")
    private String typeAccount;
    @NotNull(message = "The balance field must not be null")
    @DecimalMin(value = "0.0", message = "The balance must be greater than or equal to 0.0")
    private BigDecimal openingBalance;
    private String state;
    private String idClient;

    public AccountRequestDTO() {
    }

    public AccountRequestDTO(String accountNumber, String typeAccount, BigDecimal openingBalance, String state, String idClient) {
        this.accountNumber = accountNumber;
        this.typeAccount = typeAccount;
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

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
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

package ec.com.sofka.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ec.com.sofka.Movement;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_account")
    private String idAccount;
    @Column(nullable = false, unique = true)
    private  String accountNumber;
    private String typeAccount;
    private BigDecimal openingBalance;
    private String state;
    private String idClient;
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movement> movements;

    public AccountEntity() {
    }

    public AccountEntity(String idAccount, String accountNumber, String typeAccount, BigDecimal openingBalance, String state, String idClient, List<Movement> movements) {
        this.idAccount = idAccount;
        this.accountNumber = accountNumber;
        this.typeAccount = typeAccount;
        this.openingBalance = openingBalance;
        this.state = state;
        this.idClient = idClient;
        this.movements = movements;
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

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }
}

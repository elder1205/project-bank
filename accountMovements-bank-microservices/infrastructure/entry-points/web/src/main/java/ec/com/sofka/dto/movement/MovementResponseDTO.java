package ec.com.sofka.dto.movement;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MovementResponseDTO {
    private String idMovement;
    private LocalDateTime date;
    private String movementType;
    private BigDecimal amount;
    private BigDecimal balance;
    private String movementDescription;
    private String idAccount;

    public MovementResponseDTO() {
    }

    public MovementResponseDTO(String idMovement, LocalDateTime date, String movementType, BigDecimal amount, BigDecimal balance, String movementDescription, String idAccount) {
        this.idMovement = idMovement;
        this.date = date;
        this.movementType = movementType;
        this.amount = amount;
        this.balance = balance;
        this.movementDescription = movementDescription;
        this.idAccount = idAccount;
    }

    public String getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(String idMovement) {
        this.idMovement = idMovement;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getMovementDescription() {
        return movementDescription;
    }

    public void setMovementDescription(String movementDescription) {
        this.movementDescription = movementDescription;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }
}

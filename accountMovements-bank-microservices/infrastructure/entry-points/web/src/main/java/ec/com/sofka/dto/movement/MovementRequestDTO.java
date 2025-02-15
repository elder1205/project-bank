package ec.com.sofka.dto.movement;

import ec.com.sofka.entities.AccountEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MovementRequestDTO {
    private String idMovement;
    //private LocalDateTime date;
    private String movementType;
    private BigDecimal amount;
    //private BigDecimal balance;
    private String movementDescription;
    private String idAccount;

    public MovementRequestDTO() {
    }

    public MovementRequestDTO(String idMovement, String movementType, BigDecimal amount, String movementDescription, String idAccount) {
        this.idMovement = idMovement;
        this.movementType = movementType;
        this.amount = amount;
        this.movementDescription = movementDescription;
        this.idAccount = idAccount;
    }

    public String getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(String idMovement) {
        this.idMovement = idMovement;
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

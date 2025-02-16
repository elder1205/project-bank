package ec.com.sofka.dto.movement;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public class MovementRequestDTO {
    private String idMovement;
    //private LocalDateTime date;
    @NotBlank(message = "Type movement cannot be empty")
    @Pattern(regexp = "Deposit|Withdrawal", message = "Type account must be Deposit, Withdrawal")
    private String movementType;
    private BigDecimal amount;
    //private BigDecimal balance;
    private String movementDescription;
    private String idAccount;

    public MovementRequestDTO() {
    }

    public MovementRequestDTO( String movementType, BigDecimal amount, String movementDescription, String idAccount) {
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

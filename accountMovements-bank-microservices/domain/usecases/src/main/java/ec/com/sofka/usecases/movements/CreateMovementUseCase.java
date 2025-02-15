package ec.com.sofka.usecases.movements;

import ec.com.sofka.Account;
import ec.com.sofka.Movement;
import ec.com.sofka.gateway.AccountRepository;
import ec.com.sofka.gateway.MovementRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateMovementUseCase {
    private final MovementRepository movementRepository;
    private final AccountRepository accountRepository;


    public CreateMovementUseCase(MovementRepository movementRepository, AccountRepository accountRepository) {
        this.movementRepository = movementRepository;
        this.accountRepository = accountRepository;
    }

    public Movement execute(Movement movement){
        Account accountUpdate = accountRepository.findAccountById(movement.getAccount().getIdAccount());
        if(accountUpdate== null){
             throw new RuntimeException("The account does not exist");
        }

        BigDecimal newBalance = accountUpdate.getOpeningBalance().add(movement.getAmount());
        if(newBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Balance not  available");
        }

        movement.setDate(LocalDateTime.now());
        movement.setMovementDescription(movement.getAmount().compareTo(BigDecimal.ZERO) < 0
                ? "Withdrawal of " + movement.getAmount().negate()
                : "Deposit of " + movement.getAmount());
        movement.setBalance(newBalance);

        Movement movementNew =  this.movementRepository.saveMovement(movement);
      if(movementNew == null){
          throw new RuntimeException("Error creating movement");
      }

      accountUpdate.setOpeningBalance(newBalance);
      //accountUpdate.setOpeningBalance(movemetNew.get);
      return movementNew;
    }
}

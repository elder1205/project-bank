package ec.com.sofka.mappers;

import ec.com.sofka.Movement;
import ec.com.sofka.entities.AccountEntity;
import ec.com.sofka.entities.MovementEntity;

public class MovementMapper {

    public static Movement toModel(MovementEntity movementEntity){
        if (movementEntity == null) {
            return null;
        }
        Movement movement = new Movement();
        movement.setId(movementEntity.getIdMovement());
        movement.setDate(movementEntity.getDate());
        movement.setMovementType(movementEntity.getMovementType());
        movement.setAmount(movementEntity.getAmount());
        movement.setBalance(movementEntity.getBalance());
        movement.setMovementDescription(movement.getMovementDescription());
      //  movement.getAccount().setIdAccount(movement.getIdAccount());
        return movement;

    }

    public static MovementEntity toEntity(Movement movement) {
        if (movement == null) {
            return null;
        }
        MovementEntity movementEntity = new MovementEntity();
        movementEntity.setIdMovement(movement.getId());
        movementEntity.setDate(movement.getDate());
        movementEntity.setMovementType(movement.getMovementType());
        movementEntity.setAmount(movement.getAmount());
        movementEntity.setBalance(movement.getBalance());
        movementEntity.setMovementDescription(movement.getMovementDescription());
       movementEntity.setAccount(new AccountEntity(movement.getIdAccount()));
        return movementEntity;
    }
}

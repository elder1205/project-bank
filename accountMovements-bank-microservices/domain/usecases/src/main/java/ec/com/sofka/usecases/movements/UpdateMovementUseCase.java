package ec.com.sofka.usecases.movements;

import ec.com.sofka.Movement;
import ec.com.sofka.exceptions.MovementException;
import ec.com.sofka.gateway.MovementRepository;

public class UpdateMovementUseCase {
    private  final MovementRepository movementRepository;

    public UpdateMovementUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }
    public Movement execute(Movement movement){
        Movement movementUpdate = movementRepository.updateMovement(movement);
        if(movementUpdate == null){
            throw  new MovementException("Error updated movement");
        }
        return movementUpdate;
    }
}

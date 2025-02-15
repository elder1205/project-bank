package ec.com.sofka.usecases.movements;

import ec.com.sofka.gateway.MovementRepository;

public class DeleteMovementUseCase {
    private final MovementRepository movementRepository;

    public DeleteMovementUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }
    public void execute(String id){
        movementRepository.deleteMovement(id);
    }
}

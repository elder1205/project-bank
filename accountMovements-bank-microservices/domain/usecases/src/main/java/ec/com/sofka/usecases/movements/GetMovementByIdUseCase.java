package ec.com.sofka.usecases.movements;

import ec.com.sofka.Movement;
import ec.com.sofka.gateway.MovementRepository;


public class GetMovementByIdUseCase {
    private final MovementRepository movementRepository;

    public GetMovementByIdUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public Movement execute(String id){
   Movement movement= movementRepository.findMovementById(id);
   if(movement == null){
       throw new RuntimeException("There is no movement with id: "+id);
   }
  return movement;
    }
}

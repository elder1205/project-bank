package ec.com.sofka.usecases.movements;

import ec.com.sofka.Movement;
import ec.com.sofka.gateway.MovementRepository;

import java.util.List;

public class GetAllMovementsUseCase {
    private final MovementRepository movementRepository;

    public GetAllMovementsUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public List<Movement> execute(){
      List<Movement> movements = movementRepository.listMovements();
      if(movements.isEmpty()){
          throw new RuntimeException("No movements found");
      }
      return movements;
    }
}

package ec.com.sofka.usecases.movements;

import ec.com.sofka.Movement;
import ec.com.sofka.exceptions.MovementException;
import ec.com.sofka.exceptions.MovementNotFoundException;
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
          throw new MovementNotFoundException("No movements found");
      }
      return movements;
    }
}

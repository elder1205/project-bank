package ec.com.sofka.gateway;

import ec.com.sofka.Movement;

import java.util.List;
import java.util.Optional;

public interface MovementRepository {
    Movement saveMovement(Movement movement);
  //  Movement updateMovement(Movement movement);
    List<Movement> listMovements();
    Movement findMovementById(String id);
    Void deleteMovement(String id);
}

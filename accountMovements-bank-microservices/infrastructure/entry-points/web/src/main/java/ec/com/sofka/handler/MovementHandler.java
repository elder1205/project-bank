package ec.com.sofka.handler;

import ec.com.sofka.Movement;
import ec.com.sofka.dto.movement.MovementRequestDTO;
import ec.com.sofka.dto.movement.MovementResponseDTO;
import ec.com.sofka.mapper.MovementMapper;
import ec.com.sofka.usecases.movements.CreateMovementUseCase;
import ec.com.sofka.usecases.movements.GetAllMovementsUseCase;
import ec.com.sofka.usecases.movements.GetMovementByIdUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovementHandler {
    private final GetAllMovementsUseCase getAllMovementsUseCase;
    private final GetMovementByIdUseCase getMovementByIdUseCase;
    private final CreateMovementUseCase createMovementUseCase;

    public MovementHandler(GetAllMovementsUseCase getAllMovementsUseCase, GetMovementByIdUseCase getMovementByIdUseCase, CreateMovementUseCase createMovementUseCase) {
        this.getAllMovementsUseCase = getAllMovementsUseCase;
        this.getMovementByIdUseCase = getMovementByIdUseCase;
        this.createMovementUseCase = createMovementUseCase;
    }
    public List<MovementResponseDTO> listMovements(){
        return getAllMovementsUseCase.execute()
                .stream()
                .map(MovementMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public MovementResponseDTO save(MovementRequestDTO movementRequestDTO){
        Movement movement = MovementMapper.toModel(movementRequestDTO);
        return MovementMapper.toResponseDTO(createMovementUseCase.execute(movement));
    }

    public MovementResponseDTO findById(String data){
        Movement movement = getMovementByIdUseCase.execute(data);
        return movement != null ? MovementMapper.toResponseDTO(movement):null;
    }

}

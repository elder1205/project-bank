package ec.com.sofka.mapper;

import ec.com.sofka.Movement;
import ec.com.sofka.dto.movement.MovementRequestDTO;
import ec.com.sofka.dto.movement.MovementResponseDTO;

public class MovementMapper {
    public static Movement toModel(MovementRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        Movement movement = new Movement();
        movement.setId(dto.getIdMovement());
        movement.setMovementType(dto.getMovementType());
        movement.setAmount(dto.getAmount());
        movement.setMovementDescription(dto.getMovementDescription());
        movement.setIdAccount(dto.getIdAccount());
        return movement;
    }

    public static MovementResponseDTO toResponseDTO(Movement movement) {
        if (movement == null) {
            return null;
        }
        MovementResponseDTO responseDTO = new MovementResponseDTO();
        responseDTO.setIdMovement(movement.getId());
        responseDTO.setDate(movement.getDate());
        responseDTO.setMovementType(movement.getMovementType());
        responseDTO.setAmount(movement.getAmount());
        responseDTO.setBalance(movement.getBalance());
        responseDTO.setMovementDescription(movement.getMovementDescription());
        responseDTO.setIdAccount(movement.getIdAccount());
        return responseDTO;
    }
}

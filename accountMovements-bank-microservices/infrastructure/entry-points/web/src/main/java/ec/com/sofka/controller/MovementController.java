package ec.com.sofka.controller;

import ec.com.sofka.dto.movement.MovementRequestDTO;
import ec.com.sofka.dto.movement.MovementResponseDTO;
import ec.com.sofka.handler.MovementHandler;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movement")
public class MovementController {
    private final MovementHandler movementHandler;

    public MovementController(MovementHandler movementHandler) {
        this.movementHandler = movementHandler;
    }
    @GetMapping
    public ResponseEntity<List<MovementResponseDTO>> getAllMovements(){
        var response = movementHandler.listMovements();
        return response.isEmpty()?
                ResponseEntity.status(204).build():
                ResponseEntity.status(200).body(response);
    }

    @PostMapping
    public ResponseEntity<MovementResponseDTO> createMovement(@RequestBody @Valid MovementRequestDTO movementRequestDTO){
        var response = movementHandler.save(movementRequestDTO);
                return response !=null?
                        ResponseEntity.status(201).body(response):
                        ResponseEntity.status(500).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementResponseDTO> findById(@PathVariable String id){
        var response = movementHandler.findById(id);
        return response != null?
                ResponseEntity.status(200).body(response):
                ResponseEntity.status(404).build();
    }
}

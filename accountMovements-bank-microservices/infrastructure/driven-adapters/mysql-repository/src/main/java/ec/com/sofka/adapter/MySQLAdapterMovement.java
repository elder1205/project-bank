package ec.com.sofka.adapter;

import ec.com.sofka.Account;
import ec.com.sofka.Movement;
import ec.com.sofka.entities.MovementEntity;
import ec.com.sofka.gateway.MovementRepository;

import ec.com.sofka.mappers.MovementMapper;
import ec.com.sofka.repository.IMovementRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MySQLAdapterMovement implements MovementRepository {
    private final IMovementRepository movementRepository;

    public MySQLAdapterMovement(IMovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Override
    public Movement saveMovement(Movement movement) {
        Account account = new Account(movement.getIdAccount());
        movement.setAccount(account);

        MovementEntity movementEntity = movementRepository.save(MovementMapper.toEntity(movement));
        return MovementMapper.toModel(movementEntity);
    }

    @Override
    public List<Movement> listMovements() {
        List<MovementEntity> movementsList = movementRepository.findAll();
        return movementsList
                .stream()
                .map(MovementMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Movement findMovementById(String id) {
        MovementEntity movementEntity = movementRepository.findById(id).orElse(null);
        if (movementEntity == null) {
            throw new RuntimeException("Movement not found");
        }

        return MovementMapper.toModel(movementEntity);
    }

    @Override
    public Void deleteMovement(String id) {
        return null;
    }

    @Override
    public List<Movement> findMovementsByDateRangeAndCustomer(LocalDateTime startDate, LocalDateTime endDate, String idAccount) {
        List<MovementEntity> movementList = movementRepository.findMovementsByDateRangeAndCustomer(startDate, endDate, idAccount);
        return movementList
                .stream()
                .map(MovementMapper::toModel)
                .collect(Collectors.toList());
    }
}

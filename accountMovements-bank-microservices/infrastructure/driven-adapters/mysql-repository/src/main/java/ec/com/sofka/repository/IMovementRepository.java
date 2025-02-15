package ec.com.sofka.repository;

import ec.com.sofka.entities.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovementRepository extends JpaRepository<MovementEntity, String> {
}

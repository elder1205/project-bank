package ec.com.sofka.repository;

import ec.com.sofka.entities.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IMovementRepository extends JpaRepository<MovementEntity, String> {
    @Query("SELECT m FROM MovementEntity m WHERE m.date BETWEEN :startDate AND :endDate " +
            "AND m.account .idAccount= :idAccount " +
            "ORDER BY m.date DESC")
    List<MovementEntity> findMovementsByDateRangeAndCustomer(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("idAccount") String idAccount);
}

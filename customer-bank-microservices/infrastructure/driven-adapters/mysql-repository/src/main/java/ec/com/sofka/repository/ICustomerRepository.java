package ec.com.sofka.repository;

import ec.com.sofka.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, String> {
}

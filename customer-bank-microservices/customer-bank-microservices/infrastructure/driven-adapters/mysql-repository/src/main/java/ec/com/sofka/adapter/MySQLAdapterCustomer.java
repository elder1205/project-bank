package ec.com.sofka.adapter;

import ec.com.sofka.Customer;
import ec.com.sofka.entities.CustomerEntity;
import ec.com.sofka.gateway.CustomerRepository;
import ec.com.sofka.mappers.CustomerMapper;
import ec.com.sofka.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MySQLAdapterCustomer implements CustomerRepository {
    private final ICustomerRepository repository;

    public MySQLAdapterCustomer(ICustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
          CustomerEntity customerEntity = repository.save(CustomerMapper.toEntity(customer));
          return CustomerMapper.toModel(customerEntity);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        CustomerEntity customerEntity = repository.save(CustomerMapper.toEntity(customer));
        return CustomerMapper.toModel(customerEntity);
    }

    @Override
    public List<Customer> listTransaction() {
        List<CustomerEntity> customerEntities = repository.findAll();
        return customerEntities.stream()
                .map(CustomerMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Void deleteCustomer(String id) {
        repository.deleteById(id);
        return null;
    }
}

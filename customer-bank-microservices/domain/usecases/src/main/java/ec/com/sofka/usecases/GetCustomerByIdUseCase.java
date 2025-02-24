package ec.com.sofka.usecases;

import ec.com.sofka.Customer;
import ec.com.sofka.exceptions.CustomerNotFound;
import ec.com.sofka.gateway.CustomerRepository;

public class GetCustomerByIdUseCase {
    private final CustomerRepository customerRepository;

    public GetCustomerByIdUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer execute(String id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null) {
            throw new CustomerNotFound("There is no customer with id: " + id);
        }
        return customer;
    }
}

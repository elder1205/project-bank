package ec.com.sofka.usecases;

import ec.com.sofka.Customer;
import ec.com.sofka.gateway.CustomerRepository;

import java.util.List;

public class GetAllCustomersUseCase {
    private final CustomerRepository customerRepository;

    public GetAllCustomersUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> execute() {
        List<Customer> customers = customerRepository.listCustomer();
        if (customers.isEmpty()) {
            throw new RuntimeException("No customers found");
        }
        return customers;
    }

}

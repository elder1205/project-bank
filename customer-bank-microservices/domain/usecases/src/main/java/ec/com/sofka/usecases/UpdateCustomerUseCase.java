package ec.com.sofka.usecases;

import ec.com.sofka.Customer;
import ec.com.sofka.gateway.CustomerRepository;

public class UpdateCustomerUseCase {
    private final CustomerRepository customerRepository;

    public UpdateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Customer execute(Customer customer){
        return customerRepository.updateCustomer(customer);
    }
}

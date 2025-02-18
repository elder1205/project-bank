package ec.com.sofka.usecases;

import ec.com.sofka.Customer;
import ec.com.sofka.gateway.CustomerRepository;

public class CreateCustomerUseCase {
    private final CustomerRepository customerRepository;


    public CreateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer execute(Customer customer) {

        if (customerRepository.findCustomerByIdentification(customer.getIdentification()) == null) {
            return customerRepository.saveCustomer(customer);
        }
        throw new RuntimeException("Identification already exists");
    }
}

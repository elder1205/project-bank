package ec.com.sofka.usecases;

import ec.com.sofka.Customer;
import ec.com.sofka.exceptions.IdentificationException;
import ec.com.sofka.gateway.CustomerRepository;

public class GetCustomerByIdentificationUseCase {
    private final CustomerRepository customerRepository;

    public GetCustomerByIdentificationUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer execute(String identification) {
        Customer customer = customerRepository.findCustomerByIdentification(identification);
        if (customer == null) {
            throw new IdentificationException("Customer  with " + identification + " not found");
        }
        return customer;
    }
}

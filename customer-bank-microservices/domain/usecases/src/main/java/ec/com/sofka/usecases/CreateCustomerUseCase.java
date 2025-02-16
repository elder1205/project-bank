package ec.com.sofka.usecases;

import ec.com.sofka.Customer;
import ec.com.sofka.gateway.CustomerRepository;

public class CreateCustomerUseCase {
    private final CustomerRepository customerRepository;
    private final GetCustomerByIdentificationUseCase getCustomerByIdentificationUseCase;

    public CreateCustomerUseCase(CustomerRepository customerRepository, GetCustomerByIdentificationUseCase getCustomerByIdentificationUseCase) {
        this.customerRepository = customerRepository;
        this.getCustomerByIdentificationUseCase = getCustomerByIdentificationUseCase;
    }

    public Customer execute(Customer customer){
        System.out.println("Customer "+customer);

        if(customerRepository.findCustomerByIdentification(customer.getIdentification())== null){
            return customerRepository.saveCustomer(customer);
        }
        throw new RuntimeException("Identification already exists");
    }
}

package ec.com.sofka.usecases;

import ec.com.sofka.gateway.CustomerRepository;

public class DeleteCustomerUseCase {
    private final CustomerRepository customerRepository;

    public DeleteCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public void execute(String id){
        this.customerRepository.deleteCustomer(id);

    }
}

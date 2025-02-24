package ec.com.sofka.usecases;

import ec.com.sofka.Customer;
import ec.com.sofka.PasswordUtils;
import ec.com.sofka.exceptions.CustomerException;
import ec.com.sofka.exceptions.IdentificationException;
import ec.com.sofka.gateway.CustomerRepository;

public class UpdateCustomerUseCase {
    private final CustomerRepository customerRepository;

    public UpdateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer execute(Customer customer) {
        if (customerRepository.findCustomerByIdentification(customer.getIdentification()) == null) {
            customerRepository.findCustomerById(customer.getIdCustomer());
            customer.setPassword(PasswordUtils.encryptPassword(customer.getPassword()));
            Customer customerUpdated = customerRepository.updateCustomer(customer);
            if(customerUpdated == null){
                throw new CustomerException("Error update customer");
            }
            return customerUpdated;
        }
        throw new IdentificationException("Identification already exists");
    }
}

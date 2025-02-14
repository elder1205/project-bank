package ec.com.sofka.gateway;

import ec.com.sofka.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    List<Customer> listTransaction();
    Void deleteCustomer(String id);
}

package ec.com.sofka.mappers;

import ec.com.sofka.Customer;
import ec.com.sofka.entities.CustomerEntity;

public class CustomerMapper {
    public static Customer toModel(CustomerEntity customerEntity){
        Customer customer = new Customer();
        customer.setIdCustomer(customerEntity.getIdCustomer());
        customer.setPassword(customerEntity.getPassword());
        customer.setState(customerEntity.getState());
        customer.setIdPerson(customerEntity.getIdPerson());
        customer.setName(customerEntity.getName());
        customer.setGender(customerEntity.getGender());
        customer.setAge(customerEntity.getAge());
        customer.setIdentification(customerEntity.getIdentification());
        customer.setAddress(customerEntity.getAddress());
        customer.setPhone(customerEntity.getPhone());
        return customer;
    }

    public static CustomerEntity toEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setIdCustomer(customer.getIdCustomer());
        customerEntity.setPassword(customer.getPassword());
        customerEntity.setState(customer.getState());
        customerEntity.setIdPerson(customer.getIdPerson());
        customerEntity.setName(customer.getName());
        customerEntity.setGender(customer.getGender());
        customerEntity.setAge(customer.getAge());
        customerEntity.setIdentification(customer.getIdentification());
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setPhone(customer.getPhone());
        return customerEntity;
    }
}

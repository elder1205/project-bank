package ec.com.sofka.mapper;

import ec.com.sofka.Customer;
import ec.com.sofka.dto.CustomerRequestDTO;
import ec.com.sofka.dto.CustomerResponseDTO;

public class CustomerMapper {
    public static Customer toModel(CustomerRequestDTO dto) {
        Customer customer = new Customer();
        customer.setIdCustomer(dto.getIdCustomer());
        customer.setPassword(dto.getPassword());
        customer.setState(dto.getState());
        customer.setName(dto.getName());
        customer.setGender(dto.getGender());
        customer.setAge(dto.getAge());
        customer.setIdentification(dto.getIdentification());
        customer.setAddress(dto.getAddress());
        customer.setPhone(dto.getPhone());
        return customer;
    }

    public static CustomerResponseDTO toResponseDTO(Customer customer) {
        return new CustomerResponseDTO(
                customer.getIdCustomer(),
                customer.getState(),
                customer.getName(),
                customer.getGender(),
                customer.getAge(),
                customer.getIdentification(),
                customer.getAddress(),
                customer.getPhone()
        );
    }
}
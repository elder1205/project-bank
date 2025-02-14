package ec.com.sofka.handlers;

import ec.com.sofka.Customer;
import ec.com.sofka.dto.CustomerRequestDTO;
import ec.com.sofka.dto.CustomerResponseDTO;

import ec.com.sofka.mapper.CustomerMapper;
import ec.com.sofka.usecases.CreateCustomerUseCase;
import ec.com.sofka.usecases.GetAllCustomersUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerHandler {
    private final GetAllCustomersUseCase getAllCustomersUseCase;
    private final CreateCustomerUseCase createCustomerUseCase;

    public CustomerHandler(GetAllCustomersUseCase getAllCustomersUseCase, CreateCustomerUseCase createCustomerUseCase) {
        this.getAllCustomersUseCase = getAllCustomersUseCase;
        this.createCustomerUseCase = createCustomerUseCase;
    }

    public List<CustomerResponseDTO> findAll() {
        return getAllCustomersUseCase.execute()
                .stream()
                .map(CustomerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer = CustomerMapper.toModel(customerRequestDTO);
        Customer savedCustomer = createCustomerUseCase.execute(customer);
        return CustomerMapper.toResponseDTO(savedCustomer);
    }

}

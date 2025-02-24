package ec.com.sofka.handlers;

import ec.com.sofka.Customer;
import ec.com.sofka.dto.CustomerRequestDTO;
import ec.com.sofka.dto.CustomerResponseDTO;

import ec.com.sofka.mapper.CustomerMapper;
import ec.com.sofka.usecases.CreateCustomerUseCase;
import ec.com.sofka.usecases.GetCustomerByIdUseCase;
import ec.com.sofka.usecases.GetAllCustomersUseCase;
import ec.com.sofka.usecases.UpdateCustomerUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerHandler {
    private final GetAllCustomersUseCase getAllCustomersUseCase;
    private final CreateCustomerUseCase createCustomerUseCase;
    private final GetCustomerByIdUseCase getCustomerByIdUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;

    public CustomerHandler(GetAllCustomersUseCase getAllCustomersUseCase, CreateCustomerUseCase createCustomerUseCase, GetCustomerByIdUseCase getCustomerByIdUseCase, UpdateCustomerUseCase updateCustomerUseCase) {
        this.getAllCustomersUseCase = getAllCustomersUseCase;
        this.createCustomerUseCase = createCustomerUseCase;
        this.getCustomerByIdUseCase = getCustomerByIdUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
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

    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO){
        Customer customer = CustomerMapper.toModel(customerRequestDTO);
        Customer updateCustomer = updateCustomerUseCase.execute(customer);
        return CustomerMapper.toResponseDTO(updateCustomer);
    }

    public CustomerResponseDTO findAccountById(String id) {
        return CustomerMapper.toResponseDTO(getCustomerByIdUseCase.execute(id));
    }

}

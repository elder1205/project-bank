package ec.com.sofka.usecase;


import ec.com.sofka.Customer;
import ec.com.sofka.gateway.CustomerRepository;
import ec.com.sofka.usecases.CreateCustomerUseCase;
import ec.com.sofka.usecases.GetCustomerByIdentificationUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("CreateCustomerUseCase")
public class CreateCustomerUseCaseTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private GetCustomerByIdentificationUseCase getCustomerByIdentificationUseCase;

    @InjectMocks
    private CreateCustomerUseCase createCustomerUseCase;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("1", "name", "gender", 25, "identification", "address", "phone", "1", "password", "state");
    }

    @Test
    @DisplayName("Should create customer, when identification does not exist")
    void execute_whenIdentificationDoesNotExist_shouldCreateCustomer() {
        when(customerRepository.findCustomerByIdentification(customer.getIdentification())).thenReturn(null);
        when(customerRepository.saveCustomer(customer)).thenReturn(customer);

        Customer createdCustomer = createCustomerUseCase.execute(customer);

        assertEquals(customer, createdCustomer);
        verify(customerRepository, times(1)).findCustomerByIdentification(customer.getIdentification());
        verify(customerRepository, times(1)).saveCustomer(customer);
    }

    @Test
    @DisplayName("Should throw RuntimeException, when identification already exists")
    void execute_whenIdentificationAlreadyExists_shouldThrowRuntimeException() {
        when(customerRepository.findCustomerByIdentification(customer.getIdentification())).thenReturn(customer);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            createCustomerUseCase.execute(customer);
        });

        assertEquals("Identification already exists", exception.getMessage());
        verify(customerRepository, times(1)).findCustomerByIdentification(customer.getIdentification());
        verify(customerRepository, never()).saveCustomer(any(Customer.class));
    }
}
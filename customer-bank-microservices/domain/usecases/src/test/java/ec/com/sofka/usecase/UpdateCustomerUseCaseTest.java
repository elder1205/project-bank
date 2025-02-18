package ec.com.sofka.usecase;

import ec.com.sofka.Customer;
import ec.com.sofka.gateway.CustomerRepository;
import ec.com.sofka.usecases.UpdateCustomerUseCase;
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
@DisplayName("UpdateCustomerUseCase")
public class UpdateCustomerUseCaseTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private UpdateCustomerUseCase updateCustomerUseCase;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("1", "name", "gender", 25, "identification", "address", "phone", "1", "password", "state");
    }

    @Test
    @DisplayName("Should update customer, when customer exists")
    void execute_whenCustomerExists_shouldUpdateCustomer() {
        when(customerRepository.updateCustomer(customer)).thenReturn(customer);

        Customer updatedCustomer = updateCustomerUseCase.execute(customer);

        assertEquals(customer, updatedCustomer);
        verify(customerRepository, times(1)).updateCustomer(customer);
    }

    @Test
    @DisplayName("Should throw RuntimeException, when customer does not exist")
    void execute_whenCustomerDoesNotExist_shouldThrowRuntimeException() {
        when(customerRepository.updateCustomer(customer)).thenThrow(new RuntimeException("Customer not found"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            updateCustomerUseCase.execute(customer);
        });

        assertEquals("Customer not found", exception.getMessage());
        verify(customerRepository, times(1)).updateCustomer(customer);
    }
}
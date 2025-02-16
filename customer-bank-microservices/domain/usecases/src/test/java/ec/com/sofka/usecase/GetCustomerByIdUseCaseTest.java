package ec.com.sofka.usecase;


import ec.com.sofka.Customer;
import ec.com.sofka.gateway.CustomerRepository;
import ec.com.sofka.usecases.GetCustomerByIdUseCase;
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
@DisplayName("GetCustomerByIdUseCase")
public class GetCustomerByIdUseCaseTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private GetCustomerByIdUseCase getCustomerByIdUseCase;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("1", "name", "gender", 25, "identification", "address", "phone", "1", "password", "state");
    }

    @Test
    @DisplayName("Should return customer, when customer exists")
    void execute_whenCustomerExists_shouldReturnCustomer() {
        when(customerRepository.findAccountById("1")).thenReturn(customer);

        Customer result = getCustomerByIdUseCase.execute("1");

        assertEquals(customer, result);
        verify(customerRepository, times(1)).findAccountById("1");
    }

    @Test
    @DisplayName("Should throw RuntimeException, when customer does not exist")
    void execute_whenCustomerDoesNotExist_shouldThrowRuntimeException() {
        when(customerRepository.findAccountById("1")).thenReturn(null);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            getCustomerByIdUseCase.execute("1");
        });

        assertEquals("There is no customer with id: 1", exception.getMessage());
        verify(customerRepository, times(1)).findAccountById("1");
    }
}
package ec.com.sofka.usecase;


import ec.com.sofka.Customer;
import ec.com.sofka.gateway.CustomerRepository;
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
@DisplayName("GetCustomerByIdentificationUseCase")
public class GetCustomerByIdentificationUseCaseTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private GetCustomerByIdentificationUseCase getCustomerByIdentificationUseCase;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("1", "name", "gender", 25, "identification", "address", "phone", "1", "password", "state");
    }

    @Test
    @DisplayName("Should return customer, when customer exists")
    void execute_whenCustomerExists_shouldReturnCustomer() {
        when(customerRepository.findCustomerByIdentification("identification")).thenReturn(customer);

        Customer result = getCustomerByIdentificationUseCase.execute("identification");

        assertEquals(customer, result);
        verify(customerRepository, times(1)).findCustomerByIdentification("identification");
    }

    @Test
    @DisplayName("Should throw RuntimeException, when customer does not exist")
    void execute_whenCustomerDoesNotExist_shouldThrowRuntimeException() {
        when(customerRepository.findCustomerByIdentification("identification")).thenReturn(null);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            getCustomerByIdentificationUseCase.execute("identification");
        });

        assertEquals("Customer  with identification not found", exception.getMessage());
        verify(customerRepository, times(1)).findCustomerByIdentification("identification");
    }
}
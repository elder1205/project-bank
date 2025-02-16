package ec.com.sofka.usecase;

import ec.com.sofka.gateway.CustomerRepository;
import ec.com.sofka.usecases.DeleteCustomerUseCase;
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
@DisplayName("DeleteCustomerUseCase")
public class DeleteCustomerUseCaseTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private DeleteCustomerUseCase deleteCustomerUseCase;

    @Test
    @DisplayName("Should delete customer, when customer exists")
    void execute_whenCustomerExists_shouldDeleteCustomer() {
        String customerId = "1";
        doNothing().when(customerRepository).deleteCustomer(customerId);

        deleteCustomerUseCase.execute(customerId);

        verify(customerRepository, times(1)).deleteCustomer(customerId);
    }

    @Test
    @DisplayName("Should throw RecordNotFoundException, when customer does not exist")
    void execute_whenCustomerDoesNotExist_shouldThrowRecordNotFoundException() {
        String customerId = "456";
        doThrow(new RuntimeException("Customer with id " + customerId + " not found"))
                .when(customerRepository).deleteCustomer(customerId);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            deleteCustomerUseCase.execute(customerId);
        });

        assertEquals("Customer with id " + customerId + " not found", exception.getMessage());
        verify(customerRepository, times(1)).deleteCustomer(customerId);
    }
}

package ec.com.sofka.usecase;

import ec.com.sofka.Customer;
import ec.com.sofka.gateway.CustomerRepository;
import ec.com.sofka.usecases.GetAllCustomersUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("GetAllCustomersUseCase")
public class GetAllCustomersUseCaseTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private GetAllCustomersUseCase getAllCustomersUseCase;

    private List<Customer> customers;

    @BeforeEach
    void setUp() {
        Customer customer1 = new Customer("1", "name1", "gender1", 25, "identification1", "address1", "phone1", "1", "password1", "state1");
        Customer customer2 = new Customer("2", "name2", "gender2", 30, "identification2", "address2", "phone2", "2", "password2", "state2");
        customers = List.of(customer1, customer2);
    }

    @Test
    @DisplayName("Should return list of customers, when customers exist")
    void execute_whenCustomersExist_shouldReturnListOfCustomers() {
        when(customerRepository.listCustomer()).thenReturn(customers);

        List<Customer> result = getAllCustomersUseCase.execute();

        assertEquals(customers, result);
        verify(customerRepository, times(1)).listCustomer();
    }

    @Test
    @DisplayName("Should throw RuntimeException, when no customers found")
    void execute_whenNoCustomersFound_shouldThrowRuntimeException() {
        when(customerRepository.listCustomer()).thenReturn(Collections.emptyList());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            getAllCustomersUseCase.execute();
        });

        assertEquals("No customers found", exception.getMessage());
        verify(customerRepository, times(1)).listCustomer();
    }
}

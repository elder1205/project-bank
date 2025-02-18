package ec.com.sofka;

import ec.com.sofka.dto.CustomerRequestDTO;
import ec.com.sofka.dto.CustomerResponseDTO;
import ec.com.sofka.handlers.CustomerHandler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerHandler customerHandler;

    public CustomerController(CustomerHandler customerHandlerl) {
        this.customerHandler = customerHandlerl;
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody @Valid CustomerRequestDTO customerRequestDTO) {
        var response = customerHandler.save(customerRequestDTO);
        return response != null ?
                ResponseEntity.status(201).body(response) :
                ResponseEntity.status(500).build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        var response = customerHandler.findAll();
        return response.isEmpty() ?
                ResponseEntity.status(204).build() :
                ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> findById(@PathVariable String id) {
        var response = customerHandler.findAccountById(id);
        return response != null ?
                ResponseEntity.status(200).body(response) :
                ResponseEntity.status(404).build();
    }

}

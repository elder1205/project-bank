package ec.com.sofka.controller;

import ec.com.sofka.dto.account.AccountRequestDTO;
import ec.com.sofka.dto.account.AccountResponseDTO;
import ec.com.sofka.handler.AccountHandler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountHandler accountHandler;

    public AccountController(AccountHandler accountHandler) {
        this.accountHandler = accountHandler;
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> getAllAccounts(){
        var response = accountHandler.findAll();
                return response.isEmpty()?
                        ResponseEntity.status(204).build():
                        ResponseEntity.status(200).body(response);
    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody @Valid AccountRequestDTO accountRequestDTO){
        var response = accountHandler.save(accountRequestDTO);
        return response != null?
                ResponseEntity.status(201).body(response):
                ResponseEntity.status(500).build();
    }
@GetMapping("/{id}")
    public ResponseEntity<AccountResponseDTO> findById(@PathVariable String id){
        var response = accountHandler.getAccountById(id);
    return response != null?
            ResponseEntity.status(200).body(response):
            ResponseEntity.status(404).build();
}

}

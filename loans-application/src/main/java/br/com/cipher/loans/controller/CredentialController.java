package br.com.cipher.loans.controller;

import br.com.cipher.loans.requests.CredentialRequest;
import br.com.cipher.loans.responses.CredentialResponse;
import br.com.cipher.loans.services.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/credential")
public class CredentialController {

    private final CredentialService credentialService;

    @Autowired
    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<CredentialResponse> create(@RequestBody CredentialRequest credentialRequest) {
        CredentialResponse credentialResponse = this.credentialService.create(credentialRequest);
        return ResponseEntity.ok(credentialResponse);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<CredentialResponse> getCredential(@PathVariable Long id) {
        CredentialResponse credentialResponse = this.credentialService.getByCredentialId(id);
        return ResponseEntity.ok(credentialResponse);
    }

}

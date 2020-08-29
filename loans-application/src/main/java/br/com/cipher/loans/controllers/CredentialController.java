package br.com.cipher.loans.controllers;

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
        CredentialResponse credentialResponse = this.credentialService.execute(credentialRequest);
        return ResponseEntity.ok(credentialResponse);
    }
}

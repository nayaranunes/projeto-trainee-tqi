package br.com.cipher.loans.controller;

import br.com.cipher.loans.request.CredentialRequest;
import br.com.cipher.loans.response.CredentialResponse;
import br.com.cipher.loans.service.CredentialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Credential", description = "Class responsible by credential creation for user")
@RestController
@RequestMapping("/v1/credential")
public class CredentialController {

    private final CredentialService credentialService;

    @Autowired
    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @ApiOperation(value = "Credential creation")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<CredentialResponse> create(@RequestBody CredentialRequest credentialRequest) {
        CredentialResponse credentialResponse = this.credentialService.create(credentialRequest);
        return ResponseEntity.ok(credentialResponse);
    }

    @ApiOperation(value = "Get credential")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<CredentialResponse> getCredential(@PathVariable Long id) {
        CredentialResponse credentialResponse = this.credentialService.getByCredentialId(id);
        return ResponseEntity.ok(credentialResponse);
    }

}

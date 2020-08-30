package br.com.cipher.loans.controller;

import br.com.cipher.loans.requests.LoanRequest;
import br.com.cipher.loans.responses.AllLoans;
import br.com.cipher.loans.responses.LoanResponse;
import br.com.cipher.loans.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/loan")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<LoanResponse> create(@RequestBody LoanRequest loanRequest) {
        LoanResponse loanResponse = this.loanService.create(loanRequest);
        return ResponseEntity.ok(loanResponse);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{credentialId}")
    public ResponseEntity<AllLoans> getAllLoanByCredentialId(@PathVariable Long credentialId) {
        AllLoans loans = this.loanService.getAllLoansByCredentialId(credentialId);
        return ResponseEntity.ok(loans);
    }


}

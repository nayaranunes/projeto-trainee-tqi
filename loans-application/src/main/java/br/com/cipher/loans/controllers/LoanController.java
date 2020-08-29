package br.com.cipher.loans.controllers;

import br.com.cipher.loans.requests.LoanRequest;
import br.com.cipher.loans.responses.LoanResponse;
import br.com.cipher.loans.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/credential")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<LoanResponse> create(@RequestBody LoanRequest loanRequest) {
        LoanResponse loanResponse = this.loanService.execute(loanRequest);
        return ResponseEntity.ok(loanResponse);
    }
}

package br.com.cipher.loans.controller;

import br.com.cipher.loans.request.LoanRequest;
import br.com.cipher.loans.response.AllLoans;
import br.com.cipher.loans.response.LoanResponse;
import br.com.cipher.loans.service.LoanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Loan", description = "Class responsible by loan creation")
@RestController
@RequestMapping("/v1/loan")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @ApiOperation(value = "Loan creation")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<LoanResponse> create(@RequestBody LoanRequest loanRequest) {
        LoanResponse loanResponse = this.loanService.create(loanRequest);
        return ResponseEntity.ok(loanResponse);
    }

    @ApiOperation(value = "Get credential with all loans")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{credentialId}")
    public ResponseEntity<AllLoans> getAllLoanByCredentialId(@PathVariable Long credentialId) {
        AllLoans loans = this.loanService.getAllLoansByCredentialId(credentialId);
        return ResponseEntity.ok(loans);
    }


}

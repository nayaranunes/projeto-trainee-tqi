package br.com.cipher.loans.services;

import br.com.cipher.loans.repositories.LoanRepository;
import br.com.cipher.loans.requests.LoanRequest;
import br.com.cipher.loans.responses.CredentialResponse;
import br.com.cipher.loans.responses.LoanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }


    public LoanResponse execute(LoanRequest loanRequest) {
        return null;
    }
}

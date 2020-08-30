package br.com.cipher.loans.services;

import br.com.cipher.loans.entities.Credential;
import br.com.cipher.loans.entities.Loan;
import br.com.cipher.loans.repositories.LoanRepository;
import br.com.cipher.loans.requests.LoanRequest;
import br.com.cipher.loans.responses.AllLoans;
import br.com.cipher.loans.responses.CredentialResponse;
import br.com.cipher.loans.responses.LoanResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final CredentialService credentialService;

    @Autowired
    public LoanService(LoanRepository loanRepository, CredentialService credentialService) {
        this.loanRepository = loanRepository;
        this.credentialService = credentialService;
    }

    public LoanResponse create(LoanRequest loanRequest) {

        Credential credential = this.credentialService.getByDocument(loanRequest.getDocument());
        this.credentialService.setScorePoints(credential, loanRequest.getScorePoints());
        return this.createLoan(credential, loanRequest);
    }

    private LoanResponse createLoan(Credential credential, LoanRequest loanRequest) {

        Boolean approved = approveLoan(credential.getIncome(), loanRequest.getScorePoints(), loanRequest.getValue());
        Loan loan = new Loan(credential.getId(),loanRequest.getValue(), approved, LocalDateTime.now());
        this.loanRepository.save(loan);

        return new ModelMapper().map(loan, LoanResponse.class);
    }

    private Boolean approveLoan(Double income, Double scorePoints, Double value) {

        //score >= 800 then 80% of income is approved
        if (scorePoints >= 800 && value <= income*0.8) return true;

        //800 > score >= 700 then 70% of income is approved
        if (scorePoints < 800 && scorePoints >= 700 && value <= income*0.7) {
            return true;
        }

        //700 > score >= 600 then 50% of income is approved
        if (scorePoints < 700 && scorePoints >= 600 && value <= income*0.5) {
            return true;
        }

        //600 > score >= 500 then 30% of income is approved
        return (scorePoints < 600 && scorePoints >= 500 && value <= income * 0.3);
    }

    public AllLoans getAllLoansByCredentialId(Long credentialId) {

        Credential credential = this.credentialService.getById(credentialId);
        List<Loan> loans = this.loanRepository.getAllByCredentialId(credentialId);

        return new AllLoans(new ModelMapper().map(credential, CredentialResponse.class), loans);
    }
}

package br.com.cipher.loans.responses;

import br.com.cipher.loans.entities.Loan;

import java.util.List;

public class AllLoans {

    private CredentialResponse credentialResponse;
    private List<Loan> loans;

    public AllLoans(CredentialResponse credentialResponse, List<Loan> loans) {
        this.credentialResponse = credentialResponse;
        this.loans = loans;
    }

    public CredentialResponse getCredentialResponse() {
        return credentialResponse;
    }

    public void setCredentialResponse(CredentialResponse credentialResponse) {
        this.credentialResponse = credentialResponse;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}

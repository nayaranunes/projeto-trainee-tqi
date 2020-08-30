package br.com.cipher.loans.repositories;

import br.com.cipher.loans.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> getAllByCredentialId(Long credentialId);
}

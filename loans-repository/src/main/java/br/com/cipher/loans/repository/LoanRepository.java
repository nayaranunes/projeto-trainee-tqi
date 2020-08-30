package br.com.cipher.loans.repository;

import br.com.cipher.loans.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> getAllByCredentialId(Long credentialId);
}

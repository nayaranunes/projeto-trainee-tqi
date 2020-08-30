package br.com.cipher.loans.repository;

import br.com.cipher.loans.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Long> {

    Optional<Credential> getByDocument(String document);

    Optional<Credential> findByDocument(String document);
}

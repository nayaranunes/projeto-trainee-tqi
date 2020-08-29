package br.com.cipher.loans.repositorys;

import br.com.cipher.loans.entitys.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential, Long> {
}

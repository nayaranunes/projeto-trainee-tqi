package br.com.cipher.loans.repositories;

import br.com.cipher.loans.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByEmail(String login);

    Login findByUsername(String login);

    Optional<Login> findByUsernameAndEmail(String username, String email);
}

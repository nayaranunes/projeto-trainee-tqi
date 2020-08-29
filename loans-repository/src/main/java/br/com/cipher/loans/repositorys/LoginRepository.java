package br.com.cipher.loans.repositorys;

import br.com.cipher.loans.entitys.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
}

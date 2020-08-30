package br.com.cipher.loans.service;

import br.com.cipher.loans.entity.Login;
import br.com.cipher.loans.error.RequestException;
import br.com.cipher.loans.repository.LoginRepository;
import br.com.cipher.loans.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void execute(LoginRequest loginRequest) {
        this.login(loginRequest);
    }

    private void login(LoginRequest loginRequest) {

        Login username = getUsername(loginRequest.getLogin());
        Login email = getEmail(loginRequest.getLogin());

        if (username == null && email == null) {
            throw new RequestException("Nonexistent login, We have not met yet, how about being friends?");
        }

        //Login with username
        if (email == null) {
            if (!(loginRequest.getPassword()).equals(username.getPassword())) {
               throw new RequestException("Invalid login. Maybe your password is wrong, " +
                        "try again");
            }
        }

        //Login with email
        if (username == null) {
            if (!(loginRequest.getPassword()).equals(email.getPassword())) {
                throw new RequestException("Invalid login. Maybe your password is wrong, " +
                        "try again");
            }
        }
    }

    private Login getEmail(String login) {
        return loginRepository.findByEmail(login);
    }

    private Login getUsername(String login) {
        return loginRepository.findByUsername(login);
    }

    public Optional<Login> getLogin(String username, String email) {
        return loginRepository.findByUsernameAndEmail(username, email);
    }

    public void create(Login login) {
        this.loginRepository.saveAndFlush(login);
    }
}

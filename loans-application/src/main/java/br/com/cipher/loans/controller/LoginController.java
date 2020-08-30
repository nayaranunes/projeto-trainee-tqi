package br.com.cipher.loans.controller;

import br.com.cipher.loans.requests.LoginRequest;
import br.com.cipher.loans.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public void login(@RequestBody LoginRequest loginRequest) {
        this.loginService.execute(loginRequest);
    }

}
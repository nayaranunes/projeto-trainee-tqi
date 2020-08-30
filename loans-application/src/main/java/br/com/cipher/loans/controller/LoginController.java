package br.com.cipher.loans.controller;

import br.com.cipher.loans.request.LoginRequest;
import br.com.cipher.loans.service.LoginService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Login (e-mail) or username")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public void login(@RequestBody LoginRequest loginRequest) {
        this.loginService.execute(loginRequest);
    }

}
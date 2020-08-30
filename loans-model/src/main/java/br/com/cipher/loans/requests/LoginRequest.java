package br.com.cipher.loans.requests;

import com.sun.istack.NotNull;

public class LoginRequest {

    @NotNull
    private final String login;

    @NotNull
    private final String password;

    public LoginRequest(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}

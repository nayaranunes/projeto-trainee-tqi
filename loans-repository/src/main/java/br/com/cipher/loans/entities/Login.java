package br.com.cipher.loans.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "login")
public class Login implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "login_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "credential_id")
    private Integer credentialId;

    @OneToOne
    @JoinColumn(name = "credential_id", updatable = false, insertable = false)
    private Credential credential;

    @Column(name = "status")
    private boolean status;

    @Column(name = "password")
    private String password;

    public Login() {
        super();
    }


    public Login(String username, String email,
                 Credential credential,
                 boolean status, String password) {
        this.username = username;
        this.email = email;
        this.credential = credential;
        this.status = status;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

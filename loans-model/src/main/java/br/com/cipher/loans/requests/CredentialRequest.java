package br.com.cipher.loans.requests;

import com.sun.istack.NotNull;
import br.com.cipher.loans.entities.enums.DocumentType;
import java.time.LocalDate;

public class CredentialRequest {

    @NotNull
    private String name;
    @NotNull
    private String document;
    private DocumentType documentType;
    private LocalDate birthday;
    private Double scorePoints;
    private String phone;
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;

    public CredentialRequest() {
        super();
    }

    public CredentialRequest(String name, String document,
                             DocumentType documentType,
                             LocalDate birthday,
                             Double scorePoints,
                             String phone, String username,
                             String email, String password) {
        this.name = name;
        this.document = document;
        this.documentType = documentType;
        this.birthday = birthday;
        this.scorePoints = scorePoints;
        this.phone = phone;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Double getScorePoints() {
        return scorePoints;
    }

    public void setScorePoints(Double scorePoints) {
        this.scorePoints = scorePoints;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

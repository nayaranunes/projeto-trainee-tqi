package br.com.cipher.loans.requests;

import br.com.cipher.loans.entities.enums.DocumentType;

public class CredentialRequest {

    private final String name;
    private String document;
    private final DocumentType documentType;
    private final Double income;
    private String phone;
    private final String username;
    private final String email;
    private final String password;

    public CredentialRequest(String name, String document,
                             DocumentType documentType,
                             Double income, String phone,
                             String username, String email,
                             String password) {
        super();
        this.name = name;
        this.document = document;
        this.documentType = documentType;
        this.income = income;
        this.phone = phone;
        this.username = username;
        this.email = email;
        this.password = password;
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

    public Double getIncome() {
        return income;
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}

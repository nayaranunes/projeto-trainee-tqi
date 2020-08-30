package br.com.cipher.loans.response;

import br.com.cipher.loans.entity.DocumentType;

import java.time.LocalDateTime;

public class CredentialResponse {

    private Long id;
    private String name;
    private String document;
    private DocumentType documentType;
    private Double scorePoints;
    private Double income;
    private String phone;
    private LocalDateTime createdAt;

    public CredentialResponse() {
        super();
    }

    public CredentialResponse(Long id, String name, String document,
                              DocumentType documentType, Double scorePoints,
                              Double income, String phone, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.documentType = documentType;
        this.scorePoints = scorePoints;
        this.income = income;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Double getScorePoints() {
        return scorePoints;
    }

    public void setScorePoints(Double scorePoints) {
        this.scorePoints = scorePoints;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

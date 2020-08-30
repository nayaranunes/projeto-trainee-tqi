package br.com.cipher.loans.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "credential")
public class Credential implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "credential_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "document")
    private String document;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type")
    private DocumentType documentType;

    @Column(name = "score_points")
    private Double scorePoints;

    @Column(name = "income")
    private Double income;

    @Column(name = "phone")
    private String phone;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    

    public Credential(String name,
                      String document,
                      DocumentType documentType,
                      Double income,
                      String phone,
                      LocalDateTime createdAt) {
        this.name = name;
        this.document = document;
        this.documentType = documentType;
        this.income = income;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public Credential() {
        super();
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

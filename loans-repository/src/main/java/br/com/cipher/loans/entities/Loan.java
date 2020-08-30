package br.com.cipher.loans.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "loan")
public class Loan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "credential_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "credential_id")
    private Long credentialId;

    @Column(name = "value")
    private Double value;

    @Column(name = "approved")
    private boolean approved;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Loan() {
        super();
    }

    public Loan(Long credentialId,
                double value,
                boolean approved,
                LocalDateTime createdAt) {
        this.credentialId = credentialId;
        this.value = value;
        this.approved = approved;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Long credentialId) {
        this.credentialId = credentialId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

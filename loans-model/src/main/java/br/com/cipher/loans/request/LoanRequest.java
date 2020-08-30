package br.com.cipher.loans.request;

public class LoanRequest {

    private final Double scorePoints;
    private final String document;
    private final double value;

    public LoanRequest(Double scorePoints, String document, double value) {
        super();
        this.scorePoints = scorePoints;
        this.document = document;
        this.value = value;
    }

    public Double getScorePoints() {
        return scorePoints;
    }

    public String getDocument() {
        return document;
    }

    public double getValue() {
        return value;
    }
}

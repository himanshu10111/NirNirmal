package com.neernirmal.NeerNirmal.controller;

public class OrderRequest {

    private Double amount;
    private String currency;

    // Constructor
    public OrderRequest() {
    }

    public OrderRequest(Double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    // Getter and Setter methods
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

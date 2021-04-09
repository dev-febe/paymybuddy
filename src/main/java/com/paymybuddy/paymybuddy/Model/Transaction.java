package com.paymybuddy.paymybuddy.Model;

import java.util.Date;

public class Transaction {
    private Long id;
    private Double amount;
    private String description;
    private String status;
    private User user;

    public Transaction() {
    }

    public Transaction(Long id, Double amount, String description, String status, User user) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

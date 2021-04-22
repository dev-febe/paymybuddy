package com.paymybuddy.paymybuddy.Model;


import lombok.Data;

@Data
public class Transaction {
    private Long id;
    private Double amount;
    private String description;
    private String status;
    private User user;
    private String type;
    private Contact contact;

    public Transaction() {}

    public Transaction(Long id, Double amount, String description, String status, String type, User user, Contact contact) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.user = user;
        this.type = type;
        this.contact = contact;
    }
}

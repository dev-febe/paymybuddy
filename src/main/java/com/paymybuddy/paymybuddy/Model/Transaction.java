package com.paymybuddy.paymybuddy.Model;


import lombok.Data;

@Data
public class Transaction {
    public static final String TYPE_DEPOSIT = "DEPOSIT";
    public static final String TYPE_TRANSFER = "TRANSFER";

    public static final String STATUS_IN_RUNNING = "RUNNING";
    public static final String STATUS_IS_FAILED = "FAILED";
    public static final String STATUS_IS_OK = "OK";

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

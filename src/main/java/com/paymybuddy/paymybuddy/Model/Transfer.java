package com.paymybuddy.paymybuddy.Model;

public class Transfer {
    private Double amount;
    private String description;
    private Transaction transaction;
    private Contact contact;

    public Transfer() {}

    public Transfer(Transaction transaction, Contact contact) {
        this.transaction = transaction;
        this.contact = contact;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
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
}

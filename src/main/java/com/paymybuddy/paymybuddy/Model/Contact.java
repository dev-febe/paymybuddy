package com.paymybuddy.paymybuddy.Model;

import lombok.Data;

@Data
public class Contact {
    private Long id;
    private String name;
    private User owner;
    private User user;

    public Contact() { }

    public Contact(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

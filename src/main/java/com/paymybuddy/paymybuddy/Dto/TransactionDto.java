package com.paymybuddy.paymybuddy.Dto;

import lombok.Data;

@Data
public class TransactionDto {
    private Long contactId;
    private Long userId;
    private String type;
    private Double amount;
    private String description;
    private String status;
}

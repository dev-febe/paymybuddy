package com.paymybuddy.paymybuddy.Dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class TransactionDto {
    @Positive(message = "The connection should be selected!")
    @Min(1)
    private Long contactId;
    private Long userId;
    private String type;
    @NotNull(message = "The amount should not be null!")
    @Min(1)
    private Double amount;
    @NotBlank(message = "The description should not be null! ")
    @Size(min=0, max=300)
    private String description;
    private String status;
}

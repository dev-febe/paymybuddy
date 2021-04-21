package com.paymybuddy.paymybuddy.integrations;

import com.paymybuddy.paymybuddy.Dto.TransactionDto;
import com.paymybuddy.paymybuddy.Model.Transaction;
import com.paymybuddy.paymybuddy.Service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class TransactionIT {
    @Autowired
    TransactionService transactionService;

    @Test
    public void getTransactionsByUser_ShouldReturnAList_Test() {
        List<Transaction> transactions = transactionService.getTransactionsByUser(1L);
        assertEquals(transactions.size(), 13);
    }

    @Test
    public void saveTransaction_ShouldReturnASuccess_Test() {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setType("DEBIT");
        transactionDto.setStatus("DEBIT");
        transactionDto.setDescription("Pour achat de marchandise");
        transactionDto.setUserId(1L);
        transactionDto.setUserId(2L);
        transactionDto.setAmount(10000D);
        transactionService.saveTransaction(transactionDto);
    }
}

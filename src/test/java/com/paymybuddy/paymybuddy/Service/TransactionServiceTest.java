package com.paymybuddy.paymybuddy.Service;

import com.paymybuddy.paymybuddy.Dao.TransactionDao;
import com.paymybuddy.paymybuddy.Dto.TransactionDto;
import com.paymybuddy.paymybuddy.Model.Contact;
import com.paymybuddy.paymybuddy.Model.Transaction;
import com.paymybuddy.paymybuddy.Model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
    @Mock
    TransactionDao transactionDao;

    @InjectMocks
    TransactionService transactionService;

    //    public User(Long id, String firstName, String lastName, String password, String email, String balance) {
    @Test
    public void getTransactionsByUser_ShouldReturnAList_Test() {
        List<Transaction> _transactions = new ArrayList<>();
        _transactions.add(new Transaction());
        _transactions.add(new Transaction(1L, 100D, "Transaction", "OK", "DEBIT", new User(1L, "Kone", "Ben Fousseni", "0@12", "dd.coom", "10000", "user"), new Contact()));
        _transactions.add(new Transaction(1L, 100D, "Transaction", "OK", "DEBIT", new User(1L, "Kone", "Ben Fousseni", "0@12", "dd.coom", "10000", "user"), new Contact()));
        when(transactionDao.findTransferByUserId(1L)).thenReturn(_transactions);

        List<Transaction> transactions = transactionService.getTransactionsByUser(1L);
        assertEquals(transactions.size(), 3);
        verify(transactionDao, times(1)).findTransferByUserId(1L);
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
        verify(transactionDao, times(1)).save(transactionDto);
    }
}

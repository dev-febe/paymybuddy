package com.paymybuddy.paymybuddy.Service;

import com.paymybuddy.paymybuddy.Dao.TransactionDao;
import com.paymybuddy.paymybuddy.Dto.TransactionDto;
import com.paymybuddy.paymybuddy.Model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionDao transactionDao;

    @Autowired
    TransactionService(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public List<Transaction> getTransactionsByUser(Long userId) {
        return this.transactionDao.findTransferByUserId(userId);
    }

    public void saveTransaction(TransactionDto transactionDto) {
        this.transactionDao.save(transactionDto);
    }
}

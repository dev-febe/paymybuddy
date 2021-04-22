package com.paymybuddy.paymybuddy.Service;

import com.paymybuddy.paymybuddy.Dao.TransactionDao;
import com.paymybuddy.paymybuddy.Dao.UserDao;
import com.paymybuddy.paymybuddy.Dto.TransactionDto;
import com.paymybuddy.paymybuddy.Model.Transaction;
import com.paymybuddy.paymybuddy.Model.User;
import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionDao transactionDao;
    private final UserDao userDao;

    @Autowired
    TransactionService(TransactionDao transactionDao, UserDao userDao) {
        this.transactionDao = transactionDao;
        this.userDao = userDao;
    }

    public List<Transaction> getTransactionsByUser(Long userId) {
        return this.transactionDao.findTransferByUserId(userId);
    }

    @Transactional
    public void saveTransaction(TransactionDto transactionDto) throws Exception {
        User user = this.userDao.findById(transactionDto.getUserId());

        double accountBalance = user.getBalance() - transactionDto.getAmount();

        System.out.println(user.getBalance());
        System.out.println(accountBalance);
        if (accountBalance < 0) {
            throw new Exception("Insufficient balance");
        }
        accountBalance = accountBalance + (accountBalance * 0.5);

        this.userDao.updateBalance(user.getId(), accountBalance);

        this.transactionDao.save(transactionDto);
    }
}

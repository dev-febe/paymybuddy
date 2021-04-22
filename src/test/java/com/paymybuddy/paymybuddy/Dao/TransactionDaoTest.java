package com.paymybuddy.paymybuddy.Dao;

import com.paymybuddy.paymybuddy.Dto.TransactionDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class TransactionDaoTest {

    @Test
    public void findTransferByUserId_shouldReturnAList() {
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("bd.sql")
                .build();

        TransactionDao transactionDao = new TransactionDao(dataSource);

        assertEquals(0, transactionDao.findTransferByUserId(1L).size());

        ((EmbeddedDatabase) dataSource).shutdown();
    }

    @Test
    public void save_shouldSuccess() {
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("bd.sql")
                .build();

        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setType("DEBIT");
        transactionDto.setStatus("DEBIT");
        transactionDto.setDescription("Pour achat de marchandise");
        transactionDto.setUserId(1L);
        transactionDto.setContactId(2L);
        transactionDto.setAmount(10000D);

        TransactionDao transactionDao = new TransactionDao(dataSource);

        transactionDao.save(transactionDto);

        assertEquals(1, transactionDao.findTransferByUserId(1L).size());

        ((EmbeddedDatabase) dataSource).shutdown();
    }
}

package com.paymybuddy.paymybuddy.Dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ContactDaoTest {

    @Test
    public void findByUserId_shouldReturnAList() {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2)
                .addScript("bd.sql")
                .build();


        ContactDao contactDao = new ContactDao(dataSource);

        assertEquals(0, contactDao.findByUserId(1L).size());

        ((EmbeddedDatabase) dataSource).shutdown();
    }
}

package com.paymybuddy.paymybuddy.Dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
public class UserDaoTest {

    @Test
    public void findTransferByUserId_shouldReturnAList() {
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("bd.sql")
                .build();

        UserDao userDao = new UserDao(dataSource);

        assertNotNull(userDao.findOneByUsername("user"));

        ((EmbeddedDatabase) dataSource).shutdown();
    }
}

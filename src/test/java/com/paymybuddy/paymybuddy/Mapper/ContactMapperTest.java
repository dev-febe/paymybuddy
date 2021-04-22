package com.paymybuddy.paymybuddy.Mapper;


import com.paymybuddy.paymybuddy.Model.Contact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ContactMapperTest {
    @Test
    public void mapRowTest() throws SQLException {
        ContactMapper contactMapper = new ContactMapper();
        ResultSet inputRs = mock(ResultSet.class);
        when(inputRs.getLong("id")).thenReturn(1L);
        when(inputRs.getString("name")).thenReturn("");
        Contact contact = contactMapper.mapRow(inputRs, 1);
        assertEquals(java.util.Optional.ofNullable(contact.getId()), java.util.Optional.ofNullable(1L));
    }
}

package com.paymybuddy.paymybuddy.Mapper;


import com.paymybuddy.paymybuddy.Model.Contact;
import com.paymybuddy.paymybuddy.Model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserMapperTest {
    @Test
    public void mapRowTest() throws SQLException {
        UserMapper userMapper = new UserMapper();
        ResultSet inputRs = mock(ResultSet.class);

        when(inputRs.getLong("id")).thenReturn(1L);
        when(inputRs.getString("firstName")).thenReturn("");
        when(inputRs.getString("username")).thenReturn("");
        when(inputRs.getString("lastName")).thenReturn("");
        when(inputRs.getString("password")).thenReturn("");
        when(inputRs.getString("email")).thenReturn("");
        when(inputRs.getString("balance")).thenReturn("");
        User user = userMapper.mapRow(inputRs, 1);
        assertEquals(java.util.Optional.ofNullable(user.getId()), java.util.Optional.ofNullable(1L));
    }
}

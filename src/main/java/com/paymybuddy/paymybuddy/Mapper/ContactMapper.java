package com.paymybuddy.paymybuddy.Mapper;

import com.paymybuddy.paymybuddy.Model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements RowMapper<Contact> {
    public static final String BASE_SQL
            = "Select c.name From contact c ";

    @Override
    public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        //  User owner = new User(resultSet.getString("id"));
        //User user = resultSet.getString("username");

        return new Contact();
    }
}

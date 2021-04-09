package com.paymybuddy.paymybuddy.Mapper;

import com.paymybuddy.paymybuddy.Model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    public static final String BASE_SQL
            = "Select u.id, u.firstName, u.LastName, u.password, u.email, u.balance From user u ";

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong("id");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String password = resultSet.getString("password");
        String email = resultSet.getString("email");
        String balance = resultSet.getString("balance");

        return new User(
                id,
                firstName,
                lastName,
                password,
                email,
                balance
        );
    }
}

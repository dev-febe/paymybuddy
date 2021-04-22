package com.paymybuddy.paymybuddy.Mapper;

import com.paymybuddy.paymybuddy.Model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    public static final String BASE_SQL
            = "Select u.id, u.username, u.firstName, u.LastName, u.password, u.email, u.balance From user u ";

    public static final String INSERT
            = "INSERT INTO user (firstname, lastname, username, email, password) " +
            "VALUES (?, ?, ?, ?, ?)";

    public static final String UPDATE_BALANCE
            = "UPDATE user SET balance = ? WHERE id = ?";

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong("id");
        String firstName = resultSet.getString("firstName");
        String username = resultSet.getString("username");
        String lastName = resultSet.getString("lastName");
        String password = resultSet.getString("password");
        String email = resultSet.getString("email");
        Double balance = resultSet.getDouble("balance");

        return new User(
                id,
                firstName,
                lastName,
                password,
                email,
                balance,
                username
        );
    }
}

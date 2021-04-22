package com.paymybuddy.paymybuddy.Mapper;


import com.paymybuddy.paymybuddy.Model.Contact;
import com.paymybuddy.paymybuddy.Model.Transaction;
import com.paymybuddy.paymybuddy.Model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionMapper implements RowMapper<Transaction> {
    public static final String BASE_SQL
            = "Select c.id as contactId, c.name as contactName, o.id as ownerId, o.firstName as ownerFirstName, o.lastName as ownerLastName, " +
            "o.password as ownerPassword, o.email as ownerEmail, o.balance as ownerBalance, " +
            "ts.id as transactionId, ts.amount, ts.status, ts.description, ts.type, " +
            "u.id as userId,  u.username, u.firstName, u.lastName, u.password, u.email, u.balance " +
            "From transaction ts " +
            "Left Join contact c ON c.id = ts.contact_id " +
            "Left Join user u ON u.id = ts.user_id " +
            "Left Join user o ON o.id = c.owner_id";

    public static final String INSERT
            = "INSERT INTO transaction (amount, user_id, contact_id, status, type, description) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User(
                resultSet.getLong("userId"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getDouble("balance"),
                resultSet.getString("username")
        );

        Contact contact = new Contact(
                resultSet.getLong("contactId"),
                resultSet.getString("contactName")
        );

        return new Transaction(
                resultSet.getLong("transactionId"),
                resultSet.getDouble("amount"),
                resultSet.getString("description"),
                resultSet.getString("status"),
                resultSet.getString("type"),
                user,
                contact
        );
    }
}

package com.paymybuddy.paymybuddy.Mapper;


import com.paymybuddy.paymybuddy.Model.Contact;
import com.paymybuddy.paymybuddy.Model.Transaction;
import com.paymybuddy.paymybuddy.Model.Transfer;
import com.paymybuddy.paymybuddy.Model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferMapper implements RowMapper<Transfer> {
    public static final String BASE_SQL
            = "Select c.id as contactId, c.name as contactName, o.id as ownerId, o.firstName as ownerFirstName, o.lastName as ownerLastName, " +
            "o.password as ownerPassword, o.email as ownerEmail, o.balance as ownerBalance, " +
            "ts.id as transactionId, ts.amount, ts.status, ts.description, " +
            "u.id as userId, u.firstName, u.lastName, u.password, u.email, u.balance " +
            "From transfer t " +
            "Left Join contact c ON c.id = t.contact_id " +
            "Left Join transaction ts ON ts.id = t.transaction_id " +
            "Left Join user u ON u.id = ts.user_id " +
            "Left Join user o ON o.id = c.owner_id";

    @Override
    public Transfer mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User(
                resultSet.getLong("userId"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getString("balance")
        );

        User owner = new User(
                resultSet.getLong("ownerId"),
                resultSet.getString("ownerFirstName"),
                resultSet.getString("ownerLastName"),
                resultSet.getString("ownerPassword"),
                resultSet.getString("ownerEmail"),
                resultSet.getString("ownerBalance")
        );

        Transaction transaction = new Transaction(
                resultSet.getLong("transactionId"),
                resultSet.getDouble("amount"),
                resultSet.getString("description"),
                resultSet.getString("status"),
                user
        );

        Contact contact = new Contact(
                resultSet.getLong("contactId"),
                resultSet.getString("contactName"),
                owner,
                user
        );

        return new Transfer(transaction, contact);
    }
}

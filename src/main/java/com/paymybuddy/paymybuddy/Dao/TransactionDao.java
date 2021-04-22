package com.paymybuddy.paymybuddy.Dao;

import com.paymybuddy.paymybuddy.Dto.TransactionDto;
import com.paymybuddy.paymybuddy.Mapper.TransactionMapper;
import com.paymybuddy.paymybuddy.Model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional // commit or rollback when exception is throw
public class TransactionDao extends JdbcDaoSupport {
    @Autowired
    TransactionDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<Transaction> findTransferByUserId(Long userId) {
        Object[] params = new Object[]{userId};
        return (this.getJdbcTemplate() != null
                ? this.getJdbcTemplate()
                .query(TransactionMapper.BASE_SQL + " where u.id = ?", new TransactionMapper(), params)
                : null);
    }

    public void save(TransactionDto transaction) {
        // commit and rollback
        if (this.getJdbcTemplate() != null) {
            this.getJdbcTemplate().update(
                    TransactionMapper.INSERT,
                    transaction.getAmount(),
                    transaction.getUserId(),
                    transaction.getContactId(),
                    transaction.getStatus(),
                    transaction.getType(),
                    transaction.getDescription()
            );
        }
    }
}

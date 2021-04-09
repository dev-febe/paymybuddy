package com.paymybuddy.paymybuddy.Dao;

import com.paymybuddy.paymybuddy.Mapper.TransferMapper;
import com.paymybuddy.paymybuddy.Model.Transfer;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class TransferDao extends JdbcDaoSupport {
    TransferDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<Transfer> findTransferByUserId(Long userId) {
        return (this.getJdbcTemplate() != null
                ? this.getJdbcTemplate().query(TransferMapper.BASE_SQL, new TransferMapper())
                : null);
    }
}

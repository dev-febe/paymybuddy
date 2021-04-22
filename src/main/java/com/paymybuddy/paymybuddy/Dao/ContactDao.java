package com.paymybuddy.paymybuddy.Dao;

import com.paymybuddy.paymybuddy.Mapper.ContactMapper;
import com.paymybuddy.paymybuddy.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class ContactDao extends JdbcDaoSupport {
    @Autowired
    ContactDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<Contact> findByUserId(Long userId) {
        Object[] params = new Object[]{userId};

        return (getJdbcTemplate() != null ?
                getJdbcTemplate().query(ContactMapper.BASE_SQL  + " where c.owner_id = ?", new ContactMapper(), params)
                : null);
    }
}

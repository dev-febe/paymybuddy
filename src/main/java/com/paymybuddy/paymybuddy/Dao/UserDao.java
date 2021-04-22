package com.paymybuddy.paymybuddy.Dao;

import com.paymybuddy.paymybuddy.Mapper.UserMapper;
import com.paymybuddy.paymybuddy.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
@Transactional
public class UserDao extends JdbcDaoSupport {
    @Autowired
    UserDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public User findOneByUsername(String username) {
        Object[] params = new Object[]{username};
        System.out.println(username);
        String sql = UserMapper.BASE_SQL + " where u.username = ?";
        return this
                .getJdbcTemplate()
                .queryForObject(sql, new BeanPropertyRowMapper<>(User.class), params);
    }
}

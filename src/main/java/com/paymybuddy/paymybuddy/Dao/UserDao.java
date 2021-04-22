package com.paymybuddy.paymybuddy.Dao;

import com.paymybuddy.paymybuddy.Dto.UserDto;
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
        String sql = UserMapper.BASE_SQL + " where u.username = ?";
        return this
                .getJdbcTemplate()
                .queryForObject(sql, new BeanPropertyRowMapper<>(User.class), params);
    }

    public User findById(Long id) {
        Object[] params = new Object[]{id};
        String sql = UserMapper.BASE_SQL + " where u.id = ?";
        return this
                .getJdbcTemplate()
                .queryForObject(sql, new BeanPropertyRowMapper<>(User.class), params);
    }

    public void updateBalance(Long userId, Double balance) {
        if (this.getJdbcTemplate() != null) {
            this.getJdbcTemplate().update(
                    UserMapper.UPDATE_BALANCE,
                    userId,
                    balance
            );
        }
    }

    public void save(UserDto user) {
        if (this.getJdbcTemplate() != null) {
            this.getJdbcTemplate().update(
                    UserMapper.INSERT,
                    user.getFirstName(),
                    user.getLastName(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword()
            );
        }
    }
}

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

    public User findOneById(Long id) {
        Object[] params = new Object[]{id};
        String sql = UserMapper.BASE_SQL + " where u.id = ?";
        return (User) (this.getJdbcTemplate() != null ? this.getJdbcTemplate()
                .queryForObject(sql,
                        new BeanPropertyRowMapper<User>(User.class),
                        params) : null);
    }
}

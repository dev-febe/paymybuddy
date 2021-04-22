package com.paymybuddy.paymybuddy.Service;

import com.paymybuddy.paymybuddy.Dao.UserDao;
import com.paymybuddy.paymybuddy.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userDao.findOneByUsername(username);
    }

    @Autowired
    UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getConnectedUser() {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return this.userDao.findOneByUsername(username);
    }
}

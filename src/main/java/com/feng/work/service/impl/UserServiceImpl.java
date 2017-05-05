package com.feng.work.service.impl;

import com.feng.work.dao.UserDao;
import com.feng.work.entity.User;
import com.feng.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jarry on 2017/5/4.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User queryUser(String username, String password) {
        return null;
    }

    public User login(String username, String password) {
        return userDao.login(username, password);
    }
}

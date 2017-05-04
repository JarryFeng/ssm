package com.feng.work.dao;

import com.feng.work.entity.User;

/**
 * Created by jarry on 2017/5/4.
 */
public interface UserDao {
    public User login(String username, String password);
}

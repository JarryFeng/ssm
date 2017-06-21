package com.feng.work.user.dao;

import com.feng.work.entity.User;

/**
 * Created by jarry on 2017/5/4.
 */
public interface UserDao {
    User login(String username, String password);
}

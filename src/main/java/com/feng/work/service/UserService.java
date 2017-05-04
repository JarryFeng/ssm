package com.feng.work.service;

import com.feng.work.entity.User;

/**
 * Created by jarry on 2017/5/4.
 */
public interface UserService {

    public User queryUser(String username, String password);

    public User login(String username, String password);
}

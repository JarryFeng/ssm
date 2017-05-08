package com.feng.work.service;

import com.feng.work.entity.User;

/**
 * Created by jarry on 2017/5/4.
 */
public interface UserService {

    User queryUser(String username, String password);

    User login(String username, String password);
}

package com.feng.work.user.service.impl;

import com.feng.work.user.dao.UserDao;
import com.feng.work.user.dao.UserMapper;
import com.feng.work.entity.User;
import com.feng.work.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by jarry on 2017/5/4.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

/*    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public User login(String username, String password) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("password", password);

        return sqlSessionTemplate.selectOne("UserMapper.selectUserByUsernameAndPassword", param);
    }*/

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "cacheName", key = "#username+#password")
    public User login(String username, String password) {
        return userMapper.selectUserByUsernameAndPassword(username, password);
    }


    public User queryUser(String username, String password) {
        return null;
    }


}

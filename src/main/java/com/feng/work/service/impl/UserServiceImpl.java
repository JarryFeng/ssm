package com.feng.work.service.impl;

import com.feng.work.dao.UserDao;
import com.feng.work.dao.UserMapper;
import com.feng.work.entity.User;
import com.feng.work.service.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

        return sqlSessionTemplate.selectOne("com.feng.work.dao.UserMapper.selectUserByUsernameAndPassword", param);
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

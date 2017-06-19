package com.feng.work.dao;

import com.feng.work.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jarry on 2017/5/25.
 */
public interface UserMapper {
    public User selectUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}

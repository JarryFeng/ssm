package com.feng.work.dao.impl;

import com.feng.work.dao.UserDao;
import com.feng.work.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jarry on 2017/5/4.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private DataSource dataSource;

    public User login(String username, String password) {
        User user = null;
        try {
           Connection connection =  dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from t_user where username=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            user = new User();

            if(resultSet.next()) {
                System.out.println("" + resultSet.getString(1));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(resultSet.getInt("age"));
            }
            System.out.println("heihei");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

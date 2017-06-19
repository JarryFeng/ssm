package com.feng.work.controller;

import com.feng.work.entity.User;
import com.feng.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by jarry on 2017/5/4.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public User login(@RequestBody Map<String, String> map) {

        String username = map.get("username");
        String password = map.get("password");
        User user = null;
        try {
            user = userService.login(username, password);
            System.out.println(user);
            User user2 = userService.login(username, password);
            System.out.println(user2);
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
}

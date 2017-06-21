package com.feng.work.controller;

import com.feng.work.entity.User;
import com.feng.work.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jarry on 2017/5/4.
 */
@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/query", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public User query(@RequestParam String username, @RequestParam String password) {
        User user = userService.queryUser(username, password);
        return user;
    }
}

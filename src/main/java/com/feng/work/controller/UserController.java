package com.feng.work.controller;

import com.feng.work.entity.User;
import com.feng.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jarry on 2017/5/4.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User login2page(@RequestParam String username, @RequestParam String password) {
        User user =  userService.login(username, password);
        System.out.println("跳转到这里来了， 之前的都是假象");
        return user;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public User login(@RequestParam String username, @RequestParam String password) {
       User user =  userService.login(username, password);
       return user;
    }

    @RequestMapping(value = "/login2", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> login2(@RequestParam String username, @RequestParam String password) {
        Map<String,Object> map = new HashMap<String, Object>();
        User user =  userService.login(username, password);
        map.put("user", user);
        System.out.println("测试json格式");
        return map;
    }
}

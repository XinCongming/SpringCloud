package com.xin.controller;

import com.xin.pojo.User;
import com.xin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * http://localhost:8081/user/1
 */

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    @ResponseBody
    public User selectUser(@PathVariable("id") Long id) throws InterruptedException {
//        Thread.sleep(2000);
        User user = userService.queryById(id);
        return user;
    }
}
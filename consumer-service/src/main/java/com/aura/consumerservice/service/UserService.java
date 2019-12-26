package com.aura.consumerservice.service;

import com.aura.consumerservice.dao.UserDao;
import com.aura.consumerservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User queryUserById(Long id){
        return this.userDao.queryUserById(id);
    }

    public User queryById(Long id){
        return this.userDao.queryById(id);
    }

}
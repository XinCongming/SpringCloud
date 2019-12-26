package com.xin.service.impl;

import com.xin.dao.UserMapper;
import com.xin.pojo.User;
import com.xin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author lisir
 * @version V1.0
 * @date 2019-08-24 15:09
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Long id) throws InterruptedException {
        //为了演示超时现象，我们在这里让线程休眠，时间随机，0~2000
//        Thread.sleep(new Random().nextInt(2000));
        return userMapper.selectByPrimaryKey(id);  ///selectByPrimaryKey 通用Mapper方法
    }
}

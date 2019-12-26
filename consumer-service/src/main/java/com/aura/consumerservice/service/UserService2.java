package com.aura.consumerservice.service;

import com.aura.consumerservice.dao.UserDao2;
import com.aura.consumerservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinBa.
 * User: 辛聪明
 * Date: 2019/12/25
 */
@Service
public class UserService2 {

    @Autowired
    private UserDao2 userDao2;

    public List<User> queryUserByIds(List<Long> ids){
        List<User> list = new ArrayList<>();
        ids.forEach(id ->{
            //多次查询
            User user = this.userDao2.queryUserById(id);
            list.add(user);
        });
        return list;
    }
}

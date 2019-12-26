package com.aura.consumerservice.dao;

import com.aura.consumerservice.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xinBa.
 * User: 辛聪明
 * Date: 2019/12/25
 */

@Component
public class UserDao2 {
    @Autowired
    private RestTemplate restTemplate;

    private static Logger logger = Logger.getLogger(UserDao2.class);

    //指定错误回滚处理方法
    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    public User queryUserById(Long id){
        long begin = System.currentTimeMillis();
        String url = "http://user-service/user/"+id;
        User user = this.restTemplate.getForObject(url, User.class);

        long end = System.currentTimeMillis();
        logger.info("访问时长：{"+(end-begin)+"}");
        return user;
    }

    //这个方法与上面请求的方法返回值类型。参数列表必须一致！！！！
    public User queryUserByIdFallback(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("用户信息查询出现异常！");
        return user;
    }
}

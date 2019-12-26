package com.aura.consumerservice.controller;

import com.aura.consumerservice.service.userClient;
import com.aura.consumerservice.pojo.User;
import com.aura.consumerservice.service.UserService;
import com.aura.consumerservice.service.UserService2;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * http://localhost:8003/cs/consumer/1
 */

@RestController
@RequestMapping("consumer")
@DefaultProperties(defaultFallback = "defaultFallback")  //通用熔断处理方法
@RefreshScope
public class ConsumerController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserService2 userService2;

    @Autowired
    private userClient userClient;

//  通过id查询用户信息
    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
//        return this.userService.queryUserById(id);   //不经过eureka
//        return this.userService.queryById(id);       //eureka
        return userClient.queryUserById(id);           //feign
    }

//  查询多个id   测试随机出现超时现象
    @GetMapping("/ids/{ids}")
    public List<User> queryByIds(@PathVariable("ids") String ids) {
        List<Long> list = new ArrayList<>();
        String[] split = ids.split(",");
        for(int i=0;i<split.length;i++){
            Long id = Long.valueOf(split[i]);
            list.add(id);
        }
        List<User> users = this.userService2.queryUserByIds(list);
        return users;
    }

//    查询必定超时，user-service的service超时  queryByIdFallback回滚处理函数
    @GetMapping("/hystrix/{id}")
//    @HystrixCommand()
//    @HystrixCommand(fallbackMethod = "queryByIdFallback")  独立设定处理方法
    @HystrixCommand(commandProperties = {  //设置超时时间3000  只对此方法生效
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000"), //超时
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //最小请求次数，默认20
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//休眠时长，默认5000
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败请求最小占比，默认50%
    })
    public String queryById2(@PathVariable("id") Long id) {
        if(id%2==0){
            throw new RuntimeException("OuShu err！");
        }
        return this.userService.queryById(id).toString();
    }

    //queryById2的失败处理函数
    public String queryByIdFallback(@PathVariable("id") Long id) {
        return "--服务器忙！--";
    }

    //默认失败处理函数
    public String defaultFallback() {
        return "抱歉，服务器忙！！！！";
    }



}
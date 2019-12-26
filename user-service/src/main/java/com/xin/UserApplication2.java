package com.xin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient // 开启EurekaClient功能
@MapperScan(value = {"com.xin.dao"})    //  对应 import tk.mybatis **MapperScan
public class UserApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication2.class, args);
    }
}
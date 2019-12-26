package com.aura.consumerservice.service;

import com.aura.consumerservice.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by xinBa.
 * User: 辛聪明
 * Date: 2019/12/26
 */
@FeignClient("user-service")   //声明这是一个feign客户端
public interface userClient {

    @GetMapping("/user/{id}")
    User queryUserById(@PathVariable("id") Long id);
}

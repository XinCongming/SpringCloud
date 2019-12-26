package com.xin.service;

import com.xin.pojo.User;

/**
 * @author lisir
 * @version V1.0
 * @date 2019-08-24 15:09
 */
public interface UserService {
    public User queryById(Long id) throws InterruptedException;
}

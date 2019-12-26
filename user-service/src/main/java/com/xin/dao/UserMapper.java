package com.xin.dao;

import com.xin.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

//Mapper<User>  所有操作对象指定 User
@Repository
public interface UserMapper extends Mapper<User> {}
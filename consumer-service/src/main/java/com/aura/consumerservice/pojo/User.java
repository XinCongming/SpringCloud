package com.aura.consumerservice.pojo;

import lombok.Data;

import java.util.Date;
//如果类名和库表名一样，@Table可以省略
@Data    //@Data注解中包含了get，set和toString    不能调用set/get方法
public class User {
    private Long id;
    private String userName;//用户名    对应数据库user_name  因为userName 存在大写
    private String password;//密码
    private String name;//姓名
    private Date birthday;//生日
    private int gender;//性别： 0女性，1男性
    private Date created;//创建时间
    private Date updated;//更新时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
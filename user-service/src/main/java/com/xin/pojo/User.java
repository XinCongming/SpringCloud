package com.xin.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

// @Table声明此对象映射到数据库的数据表，通过它可以为实体指定表(talbe)
@Table(name="user")
@Data    //@Data注解中包含了get，set和toString
public class User {
    @Id  //主键字段
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String userName;//用户名    对应数据库user_name  因为userName 存在大写
    private String password;//密码
    private String name;//姓名
    private Date birthday;//生日
    private int gender;//性别： 0女性，1男性
    private Date created;//创建时间
    private Date updated;//更新时间

    //@NoArgsConstructor 是生成一个无参的构造函数，
    // @AllArgsContructor生成一个有参构造函数
}
package com.aura.consumerservice.dao;

import com.aura.consumerservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserDao {
    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;     //获取服务实例的客户端

    public User queryById(long id) {
        //方法一：通过discoveryClient获取实例得到host，port
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        ServiceInstance instance = instances.get(0);
//        String host = instance.getHost();
//        int port = instance.getPort();
//        return
//                restTemplate.getForObject("http://"+host+":"+port+"/user/"+id,User.class);

        //方法二：利用eureka通过服务应用名称获取提供服务的host+port   user-service对应提供服务端配置文件中application name
        return
                restTemplate.getForObject("http://user-service/user/"+id,User.class);
    }

    //方法三：指定url获取服务，不走eureka
    public User queryUserById(Long id){
        String url = "http://localhost:8081/user/" + id;
        return this.restTemplate.getForObject(url, User.class);
    }
}
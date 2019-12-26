package com.aura.consumerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableDiscoveryClient   //eureka client
//@EnableCircuitBreaker    //Hystrix 熔断
//@SpringBootApplication
@SpringCloudApplication    //代替上三个
@EnableFeignClients   //开启Feign
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }

    //使用HttpClient 或者urlConnection进行远程访问
    @Bean
    @LoadBalanced     //ribbon负载均衡
    public RestTemplate restTemplate(){return new RestTemplate();}
}


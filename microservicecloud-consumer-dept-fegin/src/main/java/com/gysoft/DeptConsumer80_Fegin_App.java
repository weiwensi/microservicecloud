package com.gysoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/8 10:53
 */
@SpringBootApplication
@EnableEurekaClient//负载均衡需要，标记其为Eureka的客户端
@EnableFeignClients//启用Fegin功能
public class DeptConsumer80_Fegin_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumer80_Fegin_App.class, args);
    }
}
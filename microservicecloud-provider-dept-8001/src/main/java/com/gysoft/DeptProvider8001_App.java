package com.gysoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description 服务提供者启动类启动类
 * @Author DJZ-WWS
 * @Date 2019/5/8 10:25
 */
@SpringBootApplication
@EnableEurekaClient//eureka客户端开启
@EnableDiscoveryClient //服务发现开启
public class DeptProvider8001_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(DeptProvider8001_App.class, args);
    }
}

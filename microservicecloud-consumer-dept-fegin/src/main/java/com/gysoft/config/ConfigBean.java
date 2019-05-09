package com.gysoft.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description  RestTemplate d的注入 类似applicationContext.xml
 * @Author DJZ-WWS
 * @Date 2019/5/8 10:45
 */
@Configuration
public class ConfigBean
{

    /**
     * 做一下简单的说明
     * RestTempLate 提供了多种便捷访问远程Http服务的方法，是一种简单的访问服务模板类，是spring提供的用于访问Rest服务的客户端模板工具集
     *  @LoadBalanced  注解表示开启辅在均衡策略
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}

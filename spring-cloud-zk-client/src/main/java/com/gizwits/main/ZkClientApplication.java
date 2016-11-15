package com.gizwits.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by feel on 2016/11/15.
 * <p>
 * 访问  http://127.0.0.1:9044/discovery
 * 系统会返回一个可用的服务，默认使用轮询的方法返回一个服务
 */
@SpringBootApplication(scanBasePackages = {"com.gizwits"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.gizwits.controller", "com.gizwits.service"})
public class ZkClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkClientApplication.class, args);
    }

}

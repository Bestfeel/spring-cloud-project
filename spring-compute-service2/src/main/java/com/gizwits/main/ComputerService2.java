package com.gizwits.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by feel on 2016/10/23.
 */
@EnableDiscoveryClient
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(value = "com.gizwits")
public class ComputerService2 {

    private static final Logger logger = LoggerFactory.getLogger(ComputerService2.class);


    public static void main(String[] args) throws Exception {

        //开启监控 http://localhost:8080/health

        SpringApplication.run(ComputerService2.class, args);

    }
}
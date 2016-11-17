package com.gizwits.main;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * Created by feel on 2016/11/16.
 * http://localhost:10010
 */
@EnableAdminServer   //开启监控
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
public class AdminApplication {

    private static final Logger logger = LoggerFactory.getLogger(AdminApplication.class);


    public static void main(String[] args) throws Exception {

        //开启监控 http://localhost:8080/health

        SpringApplication.run(AdminApplication.class, args);

    }
}

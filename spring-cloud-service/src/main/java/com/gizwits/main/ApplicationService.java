package com.gizwits.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by feel on 2016/10/23.
 * <p>
 * http://localhost:1111
 */
@EnableEurekaServer
@SpringBootApplication(scanBasePackages = {"com.gizwits"})
public class ApplicationService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationService.class);


    public static void main(String[] args) throws Exception {

        //开启监控 http://localhost:8080/health

        SpringApplication.run(ApplicationService.class, args);

    }
}
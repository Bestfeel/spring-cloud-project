package com.gizwits.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by feel on 2016/11/15.
 */
@SpringBootApplication(scanBasePackages = {"com.gizwits"})
@EnableDiscoveryClient
public class ZkServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(ZkServiceApplication.class);


    public static void main(String[] args) throws Exception {

        //开启监控 http://localhost:8080/health

        SpringApplication.run(ZkServiceApplication.class, args);

    }
}

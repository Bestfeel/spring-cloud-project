package com.gizwits.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by feel on 2016/10/24.
 * <p>
 * 参考 百度开源的disconf（https://github.com/knightliao/disconf ）
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = "com.gizwits")
public class ConfigClient {


    private static final Logger logger = LoggerFactory.getLogger(ConfigClient.class);


    public static void main(String[] args) throws Exception {

        SpringApplication.run(ConfigClient.class, args);

    }
}

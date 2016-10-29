package com.gizwits.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Created by feel on 2016/10/23.
 * link: http://projects.spring.io/spring-cloud/spring-cloud.html#spring-cloud-ribbon
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker //  注解开启断路器功能
@ComponentScan(value = "com.gizwits")
public class RibbonService {

    private static final Logger logger = LoggerFactory.getLogger(RibbonService.class);

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) throws Exception {

        SpringApplication.run(RibbonService.class, args);

    }
}
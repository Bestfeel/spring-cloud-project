package com.gizwits.main;

import com.gizwits.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 使用@EnableZuulProxy注解激活zuul。
 * 跟进该注解可以看到该注解整合了@EnableCircuitBreaker、@EnableDiscoveryClient，是个组合注解，目的是简化配置。
 * <p>
 * curl  http://localhost:5001/api-a/add?a=1&b=2
 * curl  http://localhost:5001/api-a/add?a=1&b=2&accessToken=token
 * curl  http://localhost:5001/api-a/add
 * curl  http://localhost:5001/api-a/add?accessToken=token
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApiGatewayApplication {

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    public static void main(String[] args) {


        SpringApplication.run(ZuulApiGatewayApplication.class, args);
    }
}

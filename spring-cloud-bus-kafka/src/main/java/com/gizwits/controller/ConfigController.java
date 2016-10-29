package com.gizwits.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by feel on 2016/10/24.
 *
 * @RefreshScope注解不能少，否则即使调用/refresh，配置也不会刷新
 */
@RestController
@RefreshScope
public class ConfigController {
    private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);


    @Value("${spring.username}")
    private String name;

    /**
     * curl  http://localhost:7005/name
     * curl -XPOST http://localhost:7005/refresh
     * curl -XPOST http://localhost:7005/bus/refresh
     * curl -XPOST http://localhost:7005/bus/refresh?destination=config-client:7005
     *
     * @return
     */
    @RequestMapping("/name")
    public String from() {
        return this.name;
    }
}

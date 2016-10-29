package com.gizwits.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by feel on 2016/10/24.
 * <p>
 * curl  http://localhost:7001/config-client-dev.properties
 * <p>
 * <p>
 * http://localhost:7001/config-client-dev/default
 * <p>
 * curl  http://localhost:7001/config-client-dev/default |python -mjson.tool
 * <p>
 * curl -XPOST http://localhost:7001/bus/refresh?destination=config-client:7003
 * <p>
 * <p>
 * curl -XPOST http://localhost:7001/bus/refresh?destination=config-client:7003
 * <p>
 * 获取git上的资源信息遵循如下规则：
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServer {


    private static final Logger logger = LoggerFactory.getLogger(ConfigServer.class);


    public static void main(String[] args) throws Exception {

        SpringApplication.run(ConfigServer.class, args);

    }
}

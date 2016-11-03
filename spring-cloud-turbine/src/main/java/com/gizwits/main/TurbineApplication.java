package com.gizwits.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by feel on 2016/11/3.
 * <p>
 * 通过@EnableTurbine接口，激活对Turbine的支持。
 * 把多个hystrix.stream的内容聚合为一个数据源供Dashboard展示
 * <p>
 * 添加 localhost:8031/turbine.stream
 */
@SpringBootApplication
@EnableTurbine
public class TurbineApplication {


    public static void main(String[] args) {

        SpringApplication.run(TurbineApplication.class, args);
    }
}

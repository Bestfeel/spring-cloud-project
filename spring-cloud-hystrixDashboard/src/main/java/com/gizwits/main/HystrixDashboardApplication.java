package com.gizwits.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by feel on 2016/11/3.
 * <p>
 * 1.  http://localhost:8030/hystrix.stream 可以查看Dashboard
 * 2. 在上面的输入框填入: http://想监控的服务:端口/hystrix.stream进行测试
 * 注意：首先要先调用一下想监控的服务的API，否则将会显示一个空的图表.
 * 访问下： curl  http://localhost:9021/add
 * 添加 localhost:9021/hystrix.stream
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {


    public static void main(String[] args) {


        SpringApplication.run(HystrixDashboardApplication.class, args);


    }
}

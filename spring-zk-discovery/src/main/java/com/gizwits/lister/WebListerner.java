package com.gizwits.lister;

import com.gizwits.registry.ServiceDetail;
import com.gizwits.registry.ServiceRegistry;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.ServiceInstanceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by feel on 2016/11/15.
 */
@Component
public class WebListerner implements ServletContextListener {

    @Autowired
    private ServiceRegistry serviceRegistry;

    @Value("${spring.application.name}")
    private String serverName;

    @Value("${server.port}")
    private int port;

    @Value("${server.address}")
    private String address;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServiceInstanceBuilder<ServiceDetail> sib = null;
        try {
            sib = ServiceInstance.builder();

            sib.address(address);
            sib.port(port);
            sib.name(serverName);
            sib.payload(new ServiceDetail("zk服务注册程序"));

            serviceRegistry.register(sib);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

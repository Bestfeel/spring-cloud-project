package com.gizwits.controller;

import com.gizwits.service.DataPointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by feel on 2016/11/15.
 */
@RestController
public class DataPointController {
    private static final Logger logger = LoggerFactory.getLogger(DataPointController.class);
    @Autowired
    private DataPointService dataPointService;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private DiscoveryClient discovery;

    /**
     * curl   http://localhost:9044/datapoint
     *
     * @return
     */
    @RequestMapping(value = "/datapoint", method = RequestMethod.GET)
    public String getDatapoint() {

        logger.info("zk  client  DataPointController..getDatapoint...");

        return dataPointService.getDatapoint("pk1");

    }


    @RequestMapping("/discovery")
    public Object discovery() {

        ServiceInstance server = loadBalancer.choose("ZkServer");


        System.out.println(server);
        return server;
    }

    @RequestMapping("/all")
    public Object all() {

        List<String> services = discovery.getServices();

        System.out.println(services);
        return services;
    }

}

package com.gizwits.controller;

import com.gizwits.service.ComputeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private ComputeService computeService;

    /**
     * curl  http://localhost:9021/add
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        logger.info("{}", "srping-ribbon-service-add2 method");
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }

    /**
     * 断路由
     * curl  http://localhost:9021/add2
     *
     * @return
     */
    @RequestMapping(value = "/add2", method = RequestMethod.GET)
    public String add2() {
        logger.info("{}", "srping-ribbon-service-add Hystrix service method");
        return computeService.addService();
    }

}
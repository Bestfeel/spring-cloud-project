package com.gizwits.controller;

import com.gizwits.service.ComputeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);
    @Autowired
    ComputeClient computeClient;


    /**
     * curl  http://localhost:9020/add
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {

        logger.info("{}", "srping-feigin-service-add2 method");

        return computeClient.add(10, 30);
    }
}


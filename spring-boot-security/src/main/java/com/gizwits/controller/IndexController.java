package com.gizwits.controller;

import com.gizwits.rabbitmq.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by feel on 2016/10/18.
 */
@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private Sender sender;


    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = {"/", "index"})
    public String index() {

        return "index";

    }


    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    // @ResponseStatus(value = HttpStatus.OK)
    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String send(@RequestParam(name = "quenaName") String quenaName, @RequestParam(name = "message") String message) {


        logger.info("{}---{}", quenaName, message);
        sender.send(quenaName, message);

        return "redirect:/hello";


    }

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}
